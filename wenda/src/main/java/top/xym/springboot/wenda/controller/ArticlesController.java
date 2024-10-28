package top.xym.springboot.wenda.controller;

//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import top.xym.springboot.wenda.common.ResponseResult;
//import top.xym.springboot.wenda.entity.Articles;
//import top.xym.springboot.wenda.mapper.ArticlesMapper;
///**
// * @author 12862
// */
//@RestController
//@RequestMapping("/articles")
//@AllArgsConstructor
//public class ArticlesController {
//    private final ArticlesMapper articlesMapper;
//
//    @GetMapping("/{articleId}")
//    public ResponseResult getArticle(@PathVariable int articleId) {
//        Articles article = articlesMapper.findArticleById(articleId);
//        Articles article1 = new Articles();
//        article1.setTitle("文章标题");
//        article1.setContent("文章内容");
//        if (article == null) {
//            return ResponseResult.builder()
//                    .code(404)
//                    .msg("文章未找到")
//                    .build();
//        }
//        return ResponseResult
//                .builder()
//                .code(200)
//                .msg("请求成功")
//                .data(article)
//                .build();
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.xym.springboot.wenda.entity.Articles;
import top.xym.springboot.wenda.mapper.ArticlesMapper;
import top.xym.springboot.wenda.repository.ArticlesRepository;
import top.xym.springboot.wenda.service.ArticlesService;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;
    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private ArticlesMapper articlesMapper;

    @PostMapping("/addarticles")
    public int addArticle(@RequestBody Articles article) {
        System.out.println("Received article: " + article);
        return articlesService.addArticle(article);
    }

    @DeleteMapping("/articles/{articleId}")
    public void deleteArticle(@PathVariable Integer articleId) {
        articlesMapper.deleteById(articleId);
    }

    @GetMapping("/list")
    public List<Articles> getArticlesList() {
        return articlesService.getAllArticles();
    }

    @GetMapping("/detail/{articleId}")
    public Articles getArticlesDetail(@PathVariable Long articleId) {
        return articlesRepository.findById(articleId).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Articles>> getArticlesByUserId(@PathVariable Integer userId) {
        List<Articles> articles = articlesService.getArticlesByUserId(userId);
        if (articles != null) {
            return ResponseEntity.ok(articles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 判断文章是否被收藏
    @GetMapping("/isCollected/{articleId}/{userId}")
    public boolean isArticleCollected(@PathVariable Integer articleId, @PathVariable Integer userId) {
        return articlesService.isArticleCollected(userId, articleId);
    }

    // 收藏文章
    @PostMapping("/collect/{articleId}/{userId}")
    public void collectArticle(@PathVariable Integer articleId, @PathVariable Integer userId) {
        articlesService.addArticleToCollection(userId, articleId);
    }

    // 取消收藏
    @DeleteMapping("/uncollect/{articleId}/{userId}")
    public void uncollectArticle(@PathVariable Integer articleId, @PathVariable Integer userId) {
        articlesService.removeArticleFromCollection(userId, articleId);
    }

    // 分页
    @GetMapping("/articles/list/page")
    public ResponseEntity<Page<Articles>> getArticlesByPage(@RequestParam int pageNumber, @RequestParam int pageSize) {
        Page<Articles> articlesPage = articlesService.getArticlesByPage(pageNumber, pageSize);
        return ResponseEntity.ok(articlesPage);
    }

}
