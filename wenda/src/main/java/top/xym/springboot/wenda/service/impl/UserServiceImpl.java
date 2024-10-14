package top.xym.springboot.wenda.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xym.springboot.wenda.entity.Result;
import top.xym.springboot.wenda.entity.User;
import top.xym.springboot.wenda.mapper.UserMapper;
import top.xym.springboot.wenda.service.UserService;

import java.util.Objects;

/**
 * @author 12862
 * 用户业务逻辑实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     * @param user 用户信息
     * @return Result
     */
    @Override
    public Result login(User user) {

        // 1. 判断用户输入的值是否符合要求？
        if (user.getAccount() == null || user.getAccount().isEmpty()) {
            return new Result("账号不能为空", 201, null);
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return new Result("密码不能为空", 201, null);
        }

        // 2. 符合要求之后，看一下数据库里面是否有对应的用户信息
        User storageUser = userMapper.getUser(user.getAccount());
        if (storageUser == null) {
            return new Result("用户不存在", 201, null);
        }

        // 3. 校验用户传进来的密码，是不是跟数据库里面存的密码一致
        if (!Objects.equals(storageUser.getPassword(), user.getPassword())) {
            return new Result("密码错误", 201, null);
        }
        return new Result("登录成功", 200, user);
    }

    /**
     *
     * @param user 用户信息
     * @return Result
     */
    @Override
    public Result register(User user) {

        // 1. 判断用户输入的值是否符合要求？
        if (user.getAccount() == null || user.getAccount().isEmpty()) {
            return new Result("账号不能为空", 201, null);
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return new Result("密码不能为空", 201, null);
        }

        // 2. 符合要求之后，看一下数据库里面是否有对应的用户信息
        User storageUser = userMapper.getUser(user.getAccount());
        if (storageUser != null) {
            return new Result("用户已存在", 201, null);
        }
        userMapper.save(user);
        return new Result("注册成功", 200, user);

    }


}
