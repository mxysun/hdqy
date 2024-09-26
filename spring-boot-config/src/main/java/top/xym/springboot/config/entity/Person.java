package top.xym.springboot.config.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author 12862
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "person")
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private UUID id;
    private String phone;
}
