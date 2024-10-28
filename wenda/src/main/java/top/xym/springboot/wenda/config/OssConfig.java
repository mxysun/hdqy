package top.xym.springboot.wenda.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Getter;

public class OssConfig {

    private static final String accessKeyId = "LTAI5tGsE1BTunhhY69GXQUD";
    private static final String accessKeySecret = "cZZGB0XJQPK307jSFGH2Wf2MtLjyTK";
    private static final String endpoint = "oss-cn-nanjing.aliyuncs.com";
    @Getter
    private static final String bucketName = "mxy-u";

    public static OSS getOssClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

}
