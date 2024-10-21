package top.xym.springboot.mp.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.mp.entity.Clazz;
import top.xym.springboot.mp.service.ClazzService;

@SpringBootTest
@Slf4j
class ClazzMapperTest {
    @Resource
    private ClazzService clazzService;

    @Test
    void getClazzWithTeacher() {
        Clazz clazzWithTeacher = clazzService.getClazzWithTeacher(2L);
        log.info(clazzWithTeacher.toString());
    }

}