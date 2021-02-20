package com.pxz.dao;

import com.pxz.pojo.Article;
import com.pxz.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUser(Integer userId);

    int deleteUser(int userId);

    int updateUser(User user);

    User login(Map<String,Object> map);

    int registerUser(User user);

//    账户是否已经存在
    int hasUser(Map<String,Object> map);

//    更新用户，插入新的用户信息
    int insertNewUser(User user);
//    根据角色id获取角色权限，0是学生， 1 是老师
    int getRole(int userId);
}
