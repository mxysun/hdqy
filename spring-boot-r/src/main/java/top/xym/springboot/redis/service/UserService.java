package top.xym.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.xym.springboot.redis.entity.User;
import top.xym.springboot.redis.vo.UserInfoVO;
import top.xym.springboot.redis.vo.UserLoginVO;

public interface UserService extends IService<User> {

    UserLoginVO loginByPhone(String phone, String code);

    boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}
