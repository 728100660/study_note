package com.pxz;

import com.pxz.dao.User;
import com.pxz.dao.UserMapper;
import com.pxz.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void selectTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectUser();

        for(User user:users){
            String s = user.toString();
            System.out.println(s);
        }

        sqlSession.close();
    }
}
