package top.xym.springboot.wenda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "articles")
// 文章
@Entity
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    private Integer userId;
    private String title;
    private String content;
    private LocalDateTime publishTime;
    private Integer likeCount;
    private Integer collectCount;

//    private List<Comments> comments;
//    private List<Likes> likes;
//    private List<Collections> collections;
}
