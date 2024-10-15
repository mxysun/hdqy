package top.xym.springboot.wenda.entity;

import lombok.Data;

/**
 * @author 12862
 */
@Data
public class Comments {
    private Integer commentId;
    private Integer articleId;
    private Integer userId;
    private String commentContent;
    private Data commentTime;
}
