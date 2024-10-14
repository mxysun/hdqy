package top.xym.springboot.database.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.database.entity.Article;
import top.xym.springboot.database.service.ArticleService;

import java.util.List;

@SpringBootTest
@Slf4j
class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot 从入门到精通")
                .build();
        Article savedArticle = articleService.saveArticle(article);
        log.info(String.valueOf(savedArticle));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(5L);
    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(3L);
        article.setTitle("SpringBoot666");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(5L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        List<Article> articles = articleService.getAll();
        articles.forEach(article -> log.info(String.valueOf(article)));
    }
}