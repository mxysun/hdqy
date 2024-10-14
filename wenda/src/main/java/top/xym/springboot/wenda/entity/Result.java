package top.xym.springboot.wenda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 12862
 */
@Data
@AllArgsConstructor
public class Result {

    private String message;
    private Integer code;
    private Object data;

}
