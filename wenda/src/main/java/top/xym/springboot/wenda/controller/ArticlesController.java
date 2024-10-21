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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xym.springboot.wenda.entity.Articles;
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

    @GetMapping("/list")
    public List<Articles> getArticlesList() {
        return articlesService.getAllArticles();
    }

    @GetMapping("/detail/{articleId}")
    public Articles getArticlesDetail(@PathVariable Long articleId) {
        return articlesRepository.findById(articleId).orElse(null);
    }

}
