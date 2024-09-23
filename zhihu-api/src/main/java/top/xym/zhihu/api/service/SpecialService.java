package top.xym.zhihu.api.service;

import org.apache.ibatis.annotations.Mapper;
import top.xym.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author 12862
 */
@Mapper
public interface SpecialService {
    List<Special> getAll();
    List<Special> getByPage(int limit, int offset);
}
