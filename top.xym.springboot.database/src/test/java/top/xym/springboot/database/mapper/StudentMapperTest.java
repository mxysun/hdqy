package top.xym.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.database.entity.Course;
import top.xym.springboot.database.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = Student.builder().clazzId(1).studentName("测试学生").hometown("江苏南京").birthday(LocalDate.now()).build();
        int n = studentMapper.insert(student);
        assertEquals(1, n);
    }

    @Test
    void findStudentById() {
        Student student = studentMapper.findStudentById(1001);
        assertEquals("钱智康", student.getStudentName());
    }

    @Test
    void updateById() {
        Student student = Student.builder()
                .studentId(1001)
                .studentName("钱智康12")
                .build();
        int n = studentMapper.updateById(student);
        assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = studentMapper.deleteById(8014);
        assertEquals(1, n);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = Student.builder()
                    .studentId(2000 + i)
                    .clazzId(1)
                    .studentName("测试学生" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(5, n);
    }

    @Test
    void batchDelete() {
        List<Integer> idList = List.of(2000, 2001, 2002, 2003, 2004);
        int n = studentMapper.batchDelete(idList);
        assertEquals(5, n);
    }

    @Test
    void selectByDynamicSql() {
        Student student = Student.builder()
                .hometown("州")
                .build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }


//    @Test //批量修改
//    void batchUpdate() {
//        List<Student> students = new ArrayList<>();
//        Student student = Student.builder().studentId(8000 + i).studentName("新名字" + i).build();
//        students.add(student);
//        int n = studentMapper.batchUpdate(students);
//        assertEquals(1, n);
//    }

    @Test
    void getStudentManyToOne() {
        Student student = studentMapper.getStudentManyToOne(1001);
        log.info("{},{},{}", student.getStudentName(), student.getHometown(), student.getClazz().getClazzName());
    }

    @Test
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info("{},{}", student.getStudentName(), student.getHometown());
        log.info("{}",student.getClazz().getClazzName());
        List<Course> courses = student.getCourse();
        courses.forEach(course -> log.info("{},{}", course.getCourseId(), course.getCourseName()));
    }
}