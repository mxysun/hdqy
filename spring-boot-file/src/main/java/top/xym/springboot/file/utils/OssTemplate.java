package top.xym.springboot.file.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.xym.springboot.file.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author 12862
 */
@Component
public class OssTemplate {

    @Resource
    private OssConfig ossConfig;

    public String ossUpload(MultipartFile file) {
        try {
            String accessKeyId = ossConfig.getAk();
            String accessKeySecret = ossConfig.getSecret();
            String endpoint = ossConfig.getEndpoint();
            String bucketName = ossConfig.getBucket();
            String dir = ossConfig.getDir();

            // 创建 OSS 客户端
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 生成文件名
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = dir + UUID.randomUUID().toString() + extension;

            // 上传文件
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, fileName, inputStream);

            // 关闭客户端
            ossClient.shutdown();

            // 返回文件访问路径
            return ossConfig.getHost() + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
//@Component
//public class OssTemplate {
//
//    @Resource
//    private OssConfig ossConfig;
//
//    public String ossUpload(MultipartFile file) {
//        String endpoint = ossConfig.getEndpoint();
//        String bucket = ossConfig.getBucket();
//        String dir = ossConfig.getDir();
//        String host = ossConfig.getHost();
//        String ak = ossConfig.getAk();
//        String secret = ossConfig.getSecret();
//
//        OSS ossClient = null;
//        try {
//            ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
//            InputStream inputStream = file.getInputStream();
//            String upleadPath = dir + file.getOriginalFilename();
//            ossClient.putObject(bucket, upleadPath, inputStream);
//            return host + "/" + upleadPath;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (ossClient!= null) {
//                ossClient.shutdown();
//            }
//        }
//    }
//}