package top.xym.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xym.springboot.task.entity.Student;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
