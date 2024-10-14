package top.xym.springboot.wenda.service;

import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;

/**
 * @author 12862
 */
public interface UserService {

    // 去封装一个响应类 Result
    Result login(User user);

    Result register(User user);

}
