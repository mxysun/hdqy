package top.xym.springboot.wenda.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 12862
 */
@Data
// 评论
public class Comments {
    private Integer commentId;
    private Integer articleId;
    private Integer userId;
    private String commentContent;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime commentTime;
}
