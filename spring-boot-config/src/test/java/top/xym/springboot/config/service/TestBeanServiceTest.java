package top.xym.springboot.config.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
class TestBeanServiceTest {
    //注⼊Spring上下⽂环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testLoadService() {
        //测试Spring上下⽂环境中是否有testBeanService这样⼀个bean，有的话表示xml配置⽂件⽣效
        boolean flag = ioc.containsBean("testBeanService");
        assertTrue(flag);
        TestBeanService testBeanService = (TestBeanService) ioc.getBean("testBeanService");
        System.out.println(testBeanService);
        log.info(String.valueOf(testBeanService));
        assertEquals("SpringBoot", testBeanService.getName());
    }
}