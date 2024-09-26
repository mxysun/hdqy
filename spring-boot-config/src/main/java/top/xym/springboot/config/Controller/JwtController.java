package top.xym.springboot.config.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.config.Util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12862
 */
@RestController
@RequestMapping("/api/jwt")
public class JwtController {
    @Resource
    private JwtUtil jwtUtil;

    /**
     * 生成JWT的接口
     * @param username 用户名
     * @return 返回生成的JWT
     */
    @PostMapping("/generate")
    public Map<String, String> generateToken(@RequestParam String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        String token = jwtUtil.generateToken(claims);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
