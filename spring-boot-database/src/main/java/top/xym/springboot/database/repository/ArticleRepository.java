package top.xym.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.xym.springboot.database.entity.Article;

/**
 * @author 12862
 */
// 这段代码定义了一个名为ArticleRepository的接口，它继承自JpaRepository<Article, Long>
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
// 1.接口的作用
// ArticleRepository作为数据访问层的接口，用于定义对Article实体的各种数据库操作方法。
// 通过继承JpaRepository，可以获得一系列内置的数据库操作方法，无需手动实现这些常见的方法，提高了开发效率。

// 2.继承的意义
// JpaRepository<Article, Long>中的<Article, Long>表示这个仓库接口是针对Article类型的实体，并且以Long类型作为实体的主键类型。
// 继承JpaRepository后，ArticleRepository自动获得了许多方便的数据库操作方法，例如：
// findById(Long id)：根据主键查找单个实体。
// save(Article article)：保存或更新一个实体。
// findAll()：查找所有实体等。

// 基于接口的编程方式和使用 JPA（Java Persistence API）的仓库模式有助于实现代码的解耦和可维护性，使业务逻辑层可以专注于处理业务规则，
// 而数据访问层负责与数据库进行交互。同时，利用 JPA 的强大功能，可以轻松地进行数据库操作，提高开发效率。