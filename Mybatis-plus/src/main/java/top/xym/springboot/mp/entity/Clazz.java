package top.xym.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 12862
 */
@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;

    // 用于一对一映射
    @TableField(exist = false)
    private Teacher teacher;
}
