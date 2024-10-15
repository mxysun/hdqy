package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
public class Collections {
    private Integer collectId;
    private Integer userId;
    private Integer collectionTime;
}
