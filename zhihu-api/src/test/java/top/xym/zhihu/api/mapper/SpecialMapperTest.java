package top.xym.zhihu.api.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.zhihu.api.entity.Special;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    @Test
    void selectAll() {
        List<Special> specials = specialMapper.selectAll();
        specials.forEach(System.out::println);
    }

    @Test
    void selectByPage() {
        List<Special> specials = specialMapper.selectByPage(5,0);
        specials.forEach(System.out::println);
    }


}