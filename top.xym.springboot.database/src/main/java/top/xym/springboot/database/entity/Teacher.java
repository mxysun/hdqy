package top.xym.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;

    private Clazz clazz;
}
