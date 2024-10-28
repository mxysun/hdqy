package top.xym.springboot.wenda.mapper;

import org.apache.ibatis.annotations.*;
import top.xym.springboot.wenda.entity.Articles;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 12862
 */
@Mapper
public interface ArticlesMapper {
    int insert(Articles article);

    Articles findArticleById(Integer articleId);

    int updateById(Articles article);

    int deleteById(Integer articleId);

    @Select("SELECT * FROM articles WHERE user_id = #{userId}")
    List<Articles> selectArticlesByUserId(@Param("userId") int userId);

    @Insert("INSERT INTO collections (user_id, article_id, collection_time) VALUES (#{userId}, #{articleId}, #{collectionTime})")
    void addCollection(@Param("userId") Integer userId, @Param("articleId") Integer articleId, @Param("collectionTime") LocalDateTime collectionTime);

    @Delete("DELETE FROM collections WHERE user_id = #{userId} AND article_id = #{articleId}")
    void removeCollection(@Param("userId") Integer userId, @Param("articleId") Integer articleId);

    // 查询用户收藏的文章列表的方法
    List<Integer> findCollectedArticleIdsByUserId(@Param("userId") Integer userId);
}
