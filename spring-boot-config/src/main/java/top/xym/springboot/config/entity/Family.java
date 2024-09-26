package top.xym.springboot.config.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import top.xym.springboot.config.loader.YamlPropertyLoader;


/**
 * @author 12862
 */
@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = YamlPropertyLoader.class)
public class Family {
    @Length(min = 5, max = 20, message = "家庭名长度必须位于5到20之间")
    private String familyName;
    private String father;
    private String mother;
    private String child;
    @Range(min = 3, message = "必须大于3年!")
    private Integer age;



}
