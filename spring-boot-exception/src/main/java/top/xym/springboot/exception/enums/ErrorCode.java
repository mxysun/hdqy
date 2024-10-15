package top.xym.springboot.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 12862
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED(401, "登录失败，请重新登录"),
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试");

    private final int code;
    // 表示异常类型的唯一编码
    private final String msg;
    // 异常的描述
}
