package top.xym.springboot.database.mapper;

import top.xym.springboot.database.entity.Clazz;

/**
 * @author 12862
 */

public interface ClazzMapper {
    Clazz getClazzById(int clazzId);

//    根据id查询班级
    Clazz getClazz(int clazzId);
}
