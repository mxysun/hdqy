package top.xym.springboot.wenda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xym.springboot.wenda.dao.UserDTO;
import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;
import top.xym.springboot.wenda.mapper.UserMapper;
import top.xym.springboot.wenda.service.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        if (user.getAccount() == null || user.getAccount().isEmpty()) {
            return new Result("账号不能为空", 400, null);
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return new Result("密码不能为空", 400, null);
        }

        User storageUser = userMapper.getUser(user.getAccount());
        if (storageUser == null) {
            return new Result("用户不存在", 401, null);
        }

        if (!Objects.equals(storageUser.getPassword(), user.getPassword())) {
            return new Result("密码错误", 401, null);
        }

        User storedUser = userMapper.getUser(user.getAccount());
        UserDTO userDTO = new UserDTO(
                storedUser.getUserId(),
                storedUser.getAccount(),
                storedUser.getUserName(),
                storedUser.getAvatar()
        );
        return new Result("登录成功", 200, userDTO);
    }

    @Transactional
    @Override
    public Result register(User user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            return new Result("昵称不能为空", 400, null);
        }
        if (user.getAccount() == null || user.getAccount().isEmpty()) {
            return new Result("账号不能为空", 400, null);
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return new Result("密码不能为空", 400, null);
        }

        // 检查用户是否存在
        User storageUser = userMapper.getUser(user.getAccount());
        if (storageUser != null) {
            return new Result("用户已存在", 400, null);
        }
        userMapper.save(user);

        // 获取自增的用户ID
        Integer userId = user.getUserId();
        // 假设ID已经通过MyBatis自动填充
        if (userId == null) {
            return new Result("无法获取用户ID", 500, null);
        }

        // 使用userId查询完整的用户信息
        User registeredUser = userMapper.findUserById(userId);
        if (registeredUser == null) {
            return new Result("用户不存在", 404, null);
        }

        // 返回包含用户信息的结果
        return new Result("注册成功", 201, registeredUser);

        // return new Result("注册成功", 201, user);
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateAvatarById(Integer userId, String avatarPath) {
        return userMapper.updateAvatarById(userId, avatarPath);
    }
}