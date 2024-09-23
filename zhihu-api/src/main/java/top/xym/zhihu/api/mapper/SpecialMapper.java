package top.xym.zhihu.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xym.zhihu.api.entity.Special;

import java.util.List;

/**
 * @author 12862
 */
@Mapper
public interface SpecialMapper {
    List<Special> selectAll();
    List<Special> selectByPage(int limit, int offset);
}
