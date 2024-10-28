package top.xym.springboot.wenda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.xym.springboot.wenda.entity.Articles;

public interface ArticlesRepository extends JpaRepository<Articles, Long> {

    // 根据发布时间升序排序查询所有文章（可用于分页查询）
    @Query("SELECT a FROM Articles a ORDER BY a.publishTime DESC")
    Page<Articles> findAllOrderByPublishTime(Pageable pageable);
}
