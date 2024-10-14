package top.xym.springboot.wenda.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.xym.springboot.wenda.entity.User;

/**
 * 用户表的持久化接口
 * @author 12862
 */
@Mapper
public interface UserMapper {

    // 注册 ---> 新增
    void save(User user);

    // 登录 ---> 查询
//    @Param(value = "account")是一个注解，用于指定参数的名称或其他属性。在这里，它表明这个参数被命名为 “account”，当调用这个方法时，需要传入一个字符串类型的账号值。
    User getUser(@Param(value = "account")String account);
}
