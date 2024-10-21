package top.xym.springboot.wenda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.entity.Comments;
import top.xym.springboot.wenda.mapper.CommentMapper;
import top.xym.springboot.wenda.service.CommentService;

import java.util.List;

/**
 * @author 12862
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comments comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<Comments> getCommentsByArticleId(Integer articleId) {
        return commentMapper.selectCommentsByArticleId(articleId);
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    @Override
    public int updateCommentContent(Integer commentId, String newContent) {
        return commentMapper.updateCommentContent(commentId, newContent);
    }

}
