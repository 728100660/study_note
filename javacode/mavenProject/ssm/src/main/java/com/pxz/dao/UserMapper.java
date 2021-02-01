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
}
