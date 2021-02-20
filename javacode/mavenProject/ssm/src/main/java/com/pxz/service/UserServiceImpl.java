package com.pxz.service;

import com.pxz.dao.ArticleMapper;
import com.pxz.dao.UserMapper;
import com.pxz.pojo.Article;
import com.pxz.pojo.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUser(Integer userId) {
        return userMapper.getUser(userId);
    }


    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User login(Map<String, Object> map) {
        return userMapper.login(map);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public int hasUser(Map<String, Object> map) {
        return userMapper.hasUser(map);
    }

    @Override
    public int insertNewUser(User user) {
        return userMapper.insertNewUser(user);
    }

    @Override
    public int getRole(int userId) {
        return userMapper.getRole(userId);
    }


}
