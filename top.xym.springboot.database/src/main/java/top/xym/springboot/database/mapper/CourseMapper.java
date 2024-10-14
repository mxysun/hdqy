package top.xym.springboot.database.mapper;

import top.xym.springboot.database.entity.Course;

import java.util.List;

/**
 * @author 12862
 */
public interface CourseMapper {
    List<Course> selectAll();
}
