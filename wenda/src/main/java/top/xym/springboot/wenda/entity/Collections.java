package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor

// 收藏
public class Collections {
    private Integer collectId;
    private Integer articleId;
    private Integer userId;
    private LocalDateTime collectionTime;
}
