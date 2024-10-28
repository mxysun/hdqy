package top.xym.springboot.wenda.service;

import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;

/**
 * @author 12862
 */
@Service
public interface UserService {

    // 去封装一个响应类 Result
    Result login(User user);

    Result register(User user);

    User findUserByUserId(Integer userId);

    // 插入用户
    int insertUser(User user);

    // 更新用户头像路径
    int updateAvatarById(Integer userId, String avatarPath);
}
