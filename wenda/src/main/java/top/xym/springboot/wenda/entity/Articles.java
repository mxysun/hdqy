package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Articles {
    private Integer articleId;
    private Integer authorId;
    private String content;
    private Data publishTime;
    private Integer likeCount;
    private Integer collectCount;
}
