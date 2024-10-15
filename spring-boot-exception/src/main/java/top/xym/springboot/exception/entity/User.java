package top.xym.springboot.exception.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.xym.springboot.exception.annotation.Phone;

/**
 * @author 12862
 */
@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 100, message= "年龄不能大于100")
    @Min(value = 1, message = "年龄不能小于1")
    private int age;

    @Phone(message = "手机号格式不正确")
    private String phone;
}
