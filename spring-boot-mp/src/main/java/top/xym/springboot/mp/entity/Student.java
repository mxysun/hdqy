package top.xym.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @author 12862
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Long clazzId;

    // 用于一对多映射
    @TableField(exist = false)
    private List<Course> courses;

}
