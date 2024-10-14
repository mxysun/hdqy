package top.xym.springboot.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12862
 */
// 自动为类生成 getter、setter、equals、hashCode 和 toString 方法
@Data
// 为类生成一个包含所有字段的构造函数。
@AllArgsConstructor
// 为类生成一个无参构造函数。
@NoArgsConstructor
// 允许使用建造者模式创建对象，可以更加灵活地设置对象的属性，提高代码的可读性和可维护性。
@Builder
// 这是 JPA（Java Persistence API）中的注解，用于标识这个类是一个实体类，将与数据库中的表进行映射。
@Entity
// 指定这个实体类对应的数据库表名
@Table(name = "t_article")
public class Article {

    // 标识为主键
    @Id
    // 表示主键生成策略为自增长，通常由数据库自动生成唯一的 ID 值。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column注解用于指定数据库表中的列属性。
    // nullable = false表示这两个字段在数据库中不允许为 null 值。
    @Column(nullable = false, length = 32)
    private String author;

    // unique = true表示title字段在数据库中必须唯一。
    @Column(nullable = false, unique = true, length = 32)
    private String title;

    @Column(length = 512)
    private String content;
}
