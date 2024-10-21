package top.xym.springboot.wenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.entity.Articles;
import top.xym.springboot.wenda.mapper.UserMapper;
import top.xym.springboot.wenda.repository.ArticlesRepository;

import java.util.List;

/**
 * @author 12862
 */
@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public List<Articles> getAllArticles() {
        return articlesRepository.findAll();
    }

//    @Autowired
//    private ArticlesMapper articlesMapper;
//
//    @Autowired
//    private CommentMapper commentMapper;
//
//    public Articles getArticlesDetail(Integer articleId) {
//        return articlesMapper.selectArticleById(articleId);
//    }
//
//    public List<Comments> getCommentsByArticleId(Integer articleId) {
//        return commentMapper.selectCommentByArticleId(articleId);
//    }

    @Autowired
    private UserMapper userMapper;



}
