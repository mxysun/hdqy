package top.xym.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 12862
 */
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

//    表示该字段在插入数据时进行填充。在这种情况下，createTime字段会在数据插入时自动填充当前时间。
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

//    意味着该字段在插入和更新数据时都会进行填充。这里的 updateTime字段会在数据插入和更新时自动更新为当前时间。
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

//    加上这个注解后，当执行删除操作时，不会真正从数据库中删除数据，而是通过修改 deleted字段的值来标记数据为已删除状态。通常，这个字段的值为 0 表示未删除，1 表示已删除。
    @TableLogic
    private Integer deleted;
}
