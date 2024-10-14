package top.xym.springboot.wenda.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;
import top.xym.springboot.wenda.service.UserService;

/**
 * @author 12862
 */
// 用户请求接口
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录接口
     * @param user 用户信息
     * @return Result
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 用户注册接口
     * @param user 用户信息
     * @return Result
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }
}
