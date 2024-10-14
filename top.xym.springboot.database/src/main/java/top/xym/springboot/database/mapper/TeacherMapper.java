package top.xym.springboot.database.mapper;

import top.xym.springboot.database.entity.Teacher;

/**
 * @author 12862
 */
public interface TeacherMapper {

    Teacher findTeacherById(int teacherId);
}
