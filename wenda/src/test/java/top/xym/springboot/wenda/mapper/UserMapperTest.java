//package top.xym.springboot.wenda.mapper;
//
//
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import top.xym.springboot.wenda.entity.User;
//
//@SpringBootTest
//@Slf4j
//class UserMapperTest {
//
//    @Resource
//    private UserMapper userMapper;
//
//    @Test
//    void getUserOneToMany() {
//        User user = userMapper.getUserOneToMany(1);
//        log.info(String.valueOf(user.getUserId()));
//        log.info(user.getUserName());
//        user.getArticles().forEach(article -> log.info(String.valueOf(article)));
//    }
//}