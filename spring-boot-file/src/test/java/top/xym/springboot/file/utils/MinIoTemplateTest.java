package top.xym.springboot.file.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

@SpringBootTest
@Slf4j
class MinIoTemplateTest {

    @Resource
    private MinIoTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        // 判断是否有 avater 这个存储桶存在
        boolean flag = minIoTemplate.bucketExists("test2");
        log.info(String.valueOf(flag));
    }

    @Test
    void makeBucket() throws Exception {
        // 创建一个名为test3 的存储桶
        minIoTemplate.makeBucket("test11");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:/pictures/nice/back.jpg");
        // 返回上传后的访问路径
        String url = minIoTemplate.putObject("test11", "test/" + UUID.randomUUID()
        + ".jpg", new FileInputStream(file));
        log.info(url);
    }

    @Test
    void removeObject() throws Exception {
        // 移除指定的文件（存在）
        minIoTemplate.removeObject("test11", "test/test.jpg");
    }
}