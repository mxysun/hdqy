package top.xym.zhihu.api.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.zhihu.api.entity.Special;


import java.util.List;

@SpringBootTest
class SpecialServiceTest {
    @Resource
    private SpecialService specialService;

    @Test
    void selectAll() {
        List<Special> all = specialService.getAll();
        all.forEach(System.out::println);
    }

    @Test
    void selectByPage() {
        List<Special> specials = specialService.getByPage(5,0);
        specials.forEach(System.out::println);
    }
}
