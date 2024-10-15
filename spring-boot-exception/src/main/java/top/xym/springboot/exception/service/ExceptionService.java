package top.xym.springboot.exception.service;

import org.springframework.stereotype.Service;
import top.xym.springboot.exception.exception.ServerException;

/**
 * @author 12862
 */
@Service
public class ExceptionService {

    // 模拟未登录异常
    public void unAuthorizedError() {
        throw new ServerException("没有登录");
    }

    // 模拟系统异常
    public void systemError() {
        throw new ServerException("系统异常");
    }
}
