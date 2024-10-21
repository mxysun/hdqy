package top.xym.springboot.wenda.service;

import top.xym.springboot.wenda.entity.Comments;

import java.util.List;

/**
 * @author 12862
 */
public interface CommentService {
    // 插入评论
    int addComment(Comments comment);

    // 根据文章 ID 获取评论列表
    List<Comments> getCommentsByArticleId(Integer articleId);

    // 删除评论
    int deleteComment(Integer commentId);

    // 更新评论内容
    int updateCommentContent(Integer commentId, String newContent);
}
