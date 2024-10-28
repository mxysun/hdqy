package top.xym.springboot.wenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.entity.Articles;
import top.xym.springboot.wenda.mapper.ArticlesMapper;
import top.xym.springboot.wenda.repository.ArticlesRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 12862
 */
@Service
public class ArticlesService {

    @Autowired
    private ArticlesMapper articleMapper;

    public int addArticle(Articles article) {
        System.out.println("Adding article: " + article);
        return articleMapper.insert(article);
    }

    private final ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public List<Articles> getAllArticles() {
        return articlesRepository.findAll();
    }

    public List<Articles> getArticlesByUserId(Integer userId) {
        return articleMapper.selectArticlesByUserId(userId);
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



    public List<Integer> findCollectedArticleIdsByUserId(Integer userId) {
        return articleMapper.findCollectedArticleIdsByUserId(userId);
    }

    public boolean isArticleCollected(Integer userId, Integer articleId) {
        List<Integer> collectedArticleIds = findCollectedArticleIdsByUserId(userId);
        return collectedArticleIds.contains(articleId);
    }

    public void addArticleToCollection(Integer userId, Integer articleId) {
        articleMapper.addCollection(userId, articleId, LocalDateTime.now());
    }

    public void removeArticleFromCollection(Integer userId, Integer articleId) {
        articleMapper.removeCollection(userId, articleId);
    }

    // 分页功能
    public Page<Articles> getArticlesByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return articlesRepository.findAllOrderByPublishTime(pageable);
    }


}
