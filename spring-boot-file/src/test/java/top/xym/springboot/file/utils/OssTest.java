package top.xym.springboot.file.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OssTest {
    private static final Logger logger = LoggerFactory.getLogger(OssTest.class);

    public static void main(String[] args) {
        String accessKeyId = "LTAI5tQnFUmsUb2gMFdE7W2d";
        String accessKeySecret = "McFDTO4w3onWHaSBjKSnFr05IfQShq";
        String endpoint = "http://oss-cn-nanjing.aliyuncs.com";

        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 可以尝试执行一些简单的操作，如获取存储桶列表等
            ossClient.listBuckets();
            ossClient.shutdown();
        } catch (Exception e) {
            logger.error("Error occurred while accessing OSS: ", e);
        }
    }
}