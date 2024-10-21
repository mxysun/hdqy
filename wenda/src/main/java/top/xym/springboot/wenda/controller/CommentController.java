package top.xym.springboot.wenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xym.springboot.wenda.entity.Comments;
import top.xym.springboot.wenda.service.CommentService;

import java.util.List;

/**
 * @author 12862
 */
@RestController
//@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 添加评论
    @PostMapping("/addComment")
    public int addComment(@RequestBody Comments comment) {
        return commentService.addComment(comment);
    }

    // 根据文章 ID 获取评论列表
    @GetMapping("/article/{articleId}")
    public List<Comments> getCommentsByArticleId(@PathVariable Integer articleId) {
        return commentService.getCommentsByArticleId(articleId);
    }

    // 删除评论
    @DeleteMapping("/{commentId}")
    public int deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteComment(commentId);
    }

    // 更新评论内容
    @PutMapping("/{commentId}")
    public int updateCommentContent(@PathVariable Integer commentId, @RequestParam String newContent) {
        return commentService.updateCommentContent(commentId, newContent);
    }
}
