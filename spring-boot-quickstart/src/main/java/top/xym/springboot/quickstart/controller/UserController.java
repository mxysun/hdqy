package top.xym.springboot.quickstart.controller;
/*
学习如何使用JDK 8 引入的 Stream API 进行数据过滤和处理。
场景设定：假设你正在开发一个简单的用户管理系统，需要过滤出年龄大于18岁的用户，
并返回这些用户的名字列表。
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.quickstart.service.UserService;

import java.util.List;

@RestController
@RequestMapping(".users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adults")
    public List<String> getAdultUserName() {
        return userService.getAdultUserNames();
    }
}
