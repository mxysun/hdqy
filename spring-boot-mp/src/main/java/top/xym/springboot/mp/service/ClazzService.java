package top.xym.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.xym.springboot.mp.entity.Clazz;
import top.xym.springboot.mp.entity.Teacher;
import top.xym.springboot.mp.mapper.ClazzMapper;

/**
 * @author 12862
 */
@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;

    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}
