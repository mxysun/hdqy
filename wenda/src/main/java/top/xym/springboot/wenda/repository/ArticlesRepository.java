package top.xym.springboot.wenda.repository;
// 数据访问层

import org.springframework.data.jpa.repository.JpaRepository;
import top.xym.springboot.wenda.entity.Articles;

/**
 * @author 12862
 */
public interface ArticlesRepository extends JpaRepository<Articles, Long> {

}
