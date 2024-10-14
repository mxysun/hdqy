package top.xym.springboot.database.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xym.springboot.database.entity.Article;
import top.xym.springboot.database.repository.ArticleRepository;
import top.xym.springboot.database.service.ArticleService;

import java.util.List;

/**
 * @author 12862
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    // 重写父类中的某个方法
    @Override
    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public Article getArticle(Long id) {
        return null;
    }

    @Override
    public List<Article> getAll() {
        return List.of();
    }

}
