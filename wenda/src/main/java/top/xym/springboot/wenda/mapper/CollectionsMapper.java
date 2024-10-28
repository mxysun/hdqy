package top.xym.springboot.wenda.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CollectionsMapper {
    @Select("SELECT article_id FROM collections WHERE user_id = #{userId}")
    List<Integer> findCollectedArticleIdsByUserId(Integer userId);

}
