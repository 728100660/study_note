package com.pxz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxz.pojo.Article;
import com.pxz.pojo.Team;
import com.pxz.pojo.User;
import com.pxz.pojo.UserTest;
import com.pxz.service.ArticleService;
import com.pxz.service.TeamService;
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

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    @Qualifier("ArticleServiceImpl")
    private ArticleService articleService;

    @Autowired
    @Qualifier("TeamServiceImpl")
    private TeamService teamService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.println("sdfassdf ");

        List<Team> teamInfo = teamService.getTeamInfo(1);

        System.out.println(2);

        int code = 0;

        Map tmpResult = ResultUtils.getResult(teamInfo, code);

        String result = JsonUtils.getJson(teamInfo);

        return result;
    }

    @ResponseBody
    @RequestMapping("/allUser")
    public String getAllUser(Model model){
        /* 获取所有用户 */
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
        /*   登录   */
//        定义map传参
        Map map = new HashMap<>();
        map.put("userAccount",userAccount);
        map.put("pwd",pwd);
        int user_id;
        int code = 1;
        User user = null;
//        查询数据
        try{
            user = userService.login(map);
            code = 0;
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
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(int userId){

        int code = 1;

        User user = null;

        try {
            user = userService.queryOneUser(userId);
            code = 0;
        }
        catch (BindingException e2){
            System.out.println("查无此人");
        }


        Map tmpResult = ResultUtils.getResult(user, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }



    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request){

//        System.out.println(user.toString());
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getPathInfo());
        System.out.println(request.getAttribute("userName"));
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/getAllArticles", method = RequestMethod.GET)
    public String getArticles(){
        /*获取全部文章*/
        int code = 0;

        List<Article> allArticles = null;

//        try {

        allArticles = articleService.getAllArticles();
//        }
//        catch (BindingException e){
//            System.out.println("数据库中没有任何文章");
//            code = 1;
//        }

        Map tmpResult = ResultUtils.getResult(allArticles, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getArticleInfo", method = RequestMethod.GET)
    public String getArticleInfo(int articleId){
        /*获取单个文章信息*/
        int code = 0;
        Article article = null;

        article = articleService.getArticleInfo(articleId);

        Map tmpResult = ResultUtils.getResult(article, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }



}
