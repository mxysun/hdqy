package top.xym.springboot.wenda.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
// 评论
public class Comments {
    private Integer commentId;
    private Integer articleId;
    private Integer userId;
    private String commentContent;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime commentTime;
}
