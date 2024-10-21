package top.xym.springboot.wenda.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xym.springboot.wenda.entity.Articles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class ArticlesMapperTest {
    @Resource
    private ArticlesMapper articlesMapper;

    @Test
    void insert() {
        Articles article = Articles.builder().userId(1).content("今天吃什么").
                publishTime(LocalDateTime.now()).likeCount(5).collectCount(5).build();
        articlesMapper.insert(article);
        int n = articlesMapper.insert(article);
        assertEquals(1,n);
    }

    @Test
    void findArticleById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }
}