package com.pxz.service;

import com.pxz.pojo.Article;
import com.pxz.pojo.User;
import org.apache.ibatis.binding.BindingException;
import org.springframework.web.util.NestedServletException;

import java.util.List;
import java.util.Map;

public interface UserService {
//    实现的时候底层是调用的UserMapper的接口
//查询用户,userId可以不传，不传参的时候查询所有
    List<User> getUser(Integer userId);
//删除一个用户
    int deleteUser(int userId);
//更新一个用户,更新的是有效时间，将老的数据失效，再插入一条新的数据
    int updateUser(User user);
//    登录
    User login(Map<String,Object> map) throws BindingException;
//    注册用户
    int registerUser(User user);

    //    账户是否已经存在
    int hasUser(Map<String,Object> map);

    //    更新用户，插入新的用户信息
    int insertNewUser(User user);

    //    根据角色id获取角色权限，0是学生， 1 是老师
    int getRole(int userId);
}
