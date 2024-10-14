package top.xym.springboot.database.mapper;

import top.xym.springboot.database.entity.Special;

import java.util.List;

/**
 * @author 12862
 */
public interface SpecialMapper {
    List<Special> findAll();
}
