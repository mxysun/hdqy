package top.xym.springboot.database.mapper;


import org.apache.ibatis.annotations.Param;
import top.xym.springboot.database.entity.Student;

import java.util.List;

/**
 * @author 12862
 */
public interface StudentMapper {

    // 插入学生信息，返回插入成功的行数
    int insert(Student student);

    // 通过学生ID查找并返回单个学生的详细信息
    Student findStudentById(int studentId);

    int updateById(Student student);

    int deleteById(int studentId);

    // 批量插入多个学生，接受一个Student对象列表，返回的是插入的总行数
    int batchInsert(@Param("students") List<Student> students);

    int batchDelete(@Param("idList") List<Integer> ids);

    // 使用动态SQL查询，根据给定的学生条件获取一组匹配的结果，返回的是一个包含匹配学生的列表。
    List<Student> selectByDynamicSql(Student student);

    int batchUpdate(@Param("students") List<Student> students);

    // 根据学生id查询（关联查询所属班级信息）
    Student getStudentManyToOne(int studentId);

    // 根据学生id查询（关联查询出所属班级信息，所选课程信息）
    Student getStudent(int studentId);

}
