package top.xym.springboot.config.Util;

import cn.hutool.jwt.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import top.xym.springboot.config.config.JwtConfig;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    @Resource
    private JwtConfig jwtConfig;

    /**
     * 生成JWT
     * @param claims 载荷信息
     * @return 生成的JWT字符串
     */
    public String generateToken(Map<String, Object> claims) {
        claims.put("exp", new Date(System.currentTimeMillis() + jwtConfig.getExpiration()));
        return JWTUtil.createToken(claims, jwtConfig.getSecret().getBytes());
    }
}
