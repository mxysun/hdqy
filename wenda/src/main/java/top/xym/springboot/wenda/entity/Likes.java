package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
public class Likes {
    private Integer likeId;
    private Integer articleId;
    private Integer userId;
    private Data likeTime;
}
