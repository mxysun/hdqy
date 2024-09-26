package top.xym.springboot.config.service;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * @author 12862
 */
@EnableConfigurationProperties
@Data
public class TestBeanService {
    private String name;
}
