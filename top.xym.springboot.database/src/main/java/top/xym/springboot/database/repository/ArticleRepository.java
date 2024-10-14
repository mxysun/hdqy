package top.xym.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.xym.springboot.database.entity.Article;

/**
 * @author 12862
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
