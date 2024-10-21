package top.xym.springboot.redis.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.xym.springboot.redis.cache.TokenStoreCache;
import top.xym.springboot.redis.enums.ErrorCode;
import top.xym.springboot.redis.exception.ServerException;
import top.xym.springboot.redis.result.Result;
import top.xym.springboot.redis.service.UserService;
import top.xym.springboot.redis.utils.JwtUtil;
import top.xym.springboot.redis.vo.UserInfoVO;
import top.xym.springboot.redis.vo.UserLoginVO;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "⼿机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String
                                                    phone, @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }

    @GetMapping("info")
    @Operation(summary = "查询⽤户信息")
    public Result<UserInfoVO> userInfo() {
// 获得 HttpServletRequest 请求对象
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
// 调⽤⼯具⽅法，从 request 中获得 accessToken
        String accessToken = JwtUtil.getAccessToken(request);
// accessToken 为空，抛出 UNAUTHORIZED 的异常信息
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
// 校验 accessToken 是否有效，⽆效也是抛出 UNAUTHORIZED 异常信息
        if (!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
// 根据 accessToken ，从 Redis 中查询到⽤户信息
        UserLoginVO user = tokenStoreCache.getUser(accessToken);
// 没查到，抛出 LOGIN_STATUS_EXPIRE 异常信息
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }
// 验证⽤户是否可⽤
        boolean enabledFlag = userService.checkUserEnabled(user.getPkId());
// 不可⽤，抛出 ACCOUNT_DISABLED 异常信息
        if (!enabledFlag) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
// 根据 id 查询到⽤户信息，返回给客户端
        return Result.ok(userService.userInfo(user.getPkId()));
    }
}
