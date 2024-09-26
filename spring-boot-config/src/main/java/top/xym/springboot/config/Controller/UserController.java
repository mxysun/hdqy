package top.xym.springboot.config.Controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.config.entity.User;

/**
 * @author 12862
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser(@Valid @RequestBody User user) {
//        如果校验失败，会自动抛出 MethodArgumentNoValidException
        return "User is valid!";
    }
}
