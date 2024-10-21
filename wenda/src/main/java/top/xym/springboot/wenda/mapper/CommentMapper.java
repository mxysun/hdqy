package top.xym.springboot.wenda.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.xym.springboot.wenda.entity.Comments;

import java.util.List;

/**
 * @author 12862
 */
@Mapper
public interface CommentMapper {
    // 插入评论
    int insertComment(Comments comment);

    // 根据问题 ID 查询评论列表
    List<Comments> selectCommentsByArticleId(@Param("articleId") Integer articleId);

    // 删除评论
    int deleteCommentById(@Param("commentId") Integer commentId);

    // 更新评论内容
    int updateCommentContent(@Param("commentId") Integer commentId, @Param("newContent") String newContent);

}
