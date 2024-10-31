package top.xym.springboot.file.utils;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Configuration
public class MinIoTemplate {

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient client;

    // 初始化服务器连接
    @PostConstruct
    public void init() {
        client = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    // 判断 bucket 是否存在
    public boolean bucketExists(String bucketName) throws Exception {
        return client.bucketExists(BucketExistsArgs
                .builder()
                .bucket(bucketName)
                .build());
    }

    // 创建 bucket
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        // 存储同不存在，可以创建
        if(!flag) {
            client.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
        }
    }

    // 上传文件
    public String putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        client.putObject(PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream, -1, 1048784784)
                        .build());
        return endPoint + "/" + bucketName + "/" + objectName;
    }

    public void removeObject(String bucketName, String objectName) throws Exception {
        client.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
}
