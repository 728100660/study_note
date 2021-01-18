package com.pxz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxz.pojo.User;
import com.pxz.service.UserService;
import com.pxz.utils.JsonUtils;
import com.pxz.utils.ResultUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller//让该类被spring扫描
@RequestMapping("/User")//路由
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @ResponseBody
    @RequestMapping("/allUser")
    public String getAllUser(Model model){
        List<User> users = userService.queryAllUser();
        String res = null;
        for(User user : users){
            String s = user.toString();
            System.out.println(s);
            res += s;
        }
//        将得到的users结果集打包成标准返回格式
        Map map = ResultUtils.getResult(users, 1);
//        json序列化
        String s = JsonUtils.getJson(map);
        return s;
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(String userAccount, @Param("password") String pwd, Model model) {
        System.out.println("wjefl");
//        定义map传参
        Map map = new HashMap<>();
        map.put("userAccount",userAccount);
        map.put("pwd",pwd);
        int user_id;
        int code = 0;
        User user = null;
//        查询数据
        try{
            user = userService.login(map);
            code = 1;
        }
        catch (BindingException e2){
            System.out.println("账户或者密码输入错误");
        }
//        封装数据
        Map result = ResultUtils.getResult(user, code);
//      转换为json
        String jsonResult = JsonUtils.getJson(result);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody Map<String,Object> param){
        Object userName = param.get("userName");
        System.out.println("接收");
        System.out.println(param);
        System.out.println(userName);

        return null;
    }
}
