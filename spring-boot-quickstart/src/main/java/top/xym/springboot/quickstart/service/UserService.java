package top.xym.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.xym.springboot.quickstart.entity.User;

import java.util.List;
import java.util.stream.Collectors;

//服务类 在其中使用Stream API 进行用户过滤和名字提取
@Service
public class UserService {

    private final List<User> users = List.of(
            new User(1L, "张三 ",22),
            new User(2l, "张三风", 17),
            new User(3l, "张三凤", 19),
            new User(4l, "张三峰", 16),
            new User(5l, "张三锋", 25)
    );

    public List<String> getAdultUserNames() {
        return users.stream()
                .filter(user -> user.getAge() > 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
