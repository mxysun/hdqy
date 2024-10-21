package top.xym.springboot.wenda.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.xym.springboot.wenda.entity.Articles;

/**
 * @author 12862
 */
@Mapper
public interface ArticlesMapper {
    int insert(Articles article);

    Articles findArticleById(Integer articleId);

    int updateById(Articles article);

    int deleteById(Integer articleId);


}
