package com.pxz.dao;

import com.pxz.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int addUser(User user);

    User queryOneUser(int userId);

    List<User> queryAllUser();

    int deleteUser(int userId);

    int updateUser(User user);

    User login(Map<String,Object> map);
}
