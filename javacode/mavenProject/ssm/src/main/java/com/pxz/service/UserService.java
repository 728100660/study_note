package com.pxz.service;

import com.pxz.pojo.Article;
import com.pxz.pojo.User;
import org.apache.ibatis.binding.BindingException;
import org.springframework.web.util.NestedServletException;

import java.util.List;
import java.util.Map;

public interface UserService {
//    实现的时候底层是调用的UserMapper的接口
//    增加一个用户
    int addUser(User user);
//查询一个用户
    User queryOneUser(int userId);
//查询所有用户
    List<User> queryAllUser();
//删除一个用户
    int deleteUser(int userId);
//更新一个用户
    int updateUser(User user);
//    登录
    User login(Map<String,Object> map) throws BindingException;

}
