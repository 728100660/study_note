package com.pxz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pxz.pojo.*;
import com.pxz.service.*;
import com.pxz.utils.JsonUtils;
import com.pxz.utils.ResultUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;


@Controller//让该类被spring扫描
@RequestMapping("/project")//路由
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

    @Autowired
    @Qualifier("NoticeServiceImpl")
    private NoticeService noticeService;


    @Autowired
    @Qualifier("CommentServiceImpl")
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(Integer teamId) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(name = "account") String userAccount, @RequestParam(name = "password") String pwd) {
        /**   登录   **/
//        定义map传参
        Map map = new HashMap<>();
        System.out.println(userAccount);
        map.put("userAccount", userAccount);
        map.put("pwd", pwd);
        for (Object m : map.keySet()) {
            System.out.println(map.get(m));
        }
        int code = 1;
        User user = null;
        String msg = "";
//        查询数据
        try {
            user = userService.login(map);
//            System.out.println(user.toString());
            if (user != null) {
                code = 0;
            } else {
                msg = "账号或者密码输入错误, account or password error";
            }
        } catch (BindingException e2) {
            System.out.println("账户或者密码输入错误");
        }
//        封装数据
        Map result = ResultUtils.getResult(user, code, msg);
//      转换为json
        String jsonResult = JsonUtils.getJson(result);
        return jsonResult;
    }


    @ResponseBody
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(Integer userId) {
        /**获取用户信息，userId可以为空，空时查询所有数据返回**/
        int code = 0;

        List<User> users = null;

//        try {
//            users = userService.getUser(userId);
//            code = 0;
//        } catch (BindingException e2) {
//            System.out.println("查无此人");
//        }
        users = userService.getUser(userId);

        Map tmpResult = ResultUtils.getResult(users, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(User user) {
        /**注册用户**/
        int data = 0;
        int code = 0;
        String msg = "成功，success";

        HashMap<String, Object> map = new HashMap<>();
        map.put("account", user.getAccount());
        map.put("email", user.getEmail());
        map.put("phoneNumber", user.getPhoneNumber());
        if (userService.hasUser(map) > 0) {
            msg = "账号已存在或者邮箱和电话号码已经被绑定, account is already exist";
            code = 1;
        } else {
            data = userService.registerUser(user);
        }


        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getArticleInfo", method = RequestMethod.GET)
    public String getArticles(Integer articleId, String searchString) {
        /**获取文章**/
        int code = 0;
        String msg = "成功, success";

        List<Article> allArticles = null;

        HashMap<String, Object> map = new HashMap<>();

        map.put("articleId", articleId);
        map.put("searchString", searchString);

//        try {

        allArticles = articleService.getArticleInfo(map);
//        }
//        catch (BindingException e){
//            System.out.println("数据库中没有任何文章");
//            code = 1;
//        }

        Map tmpResult = ResultUtils.getResult(allArticles, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        /**更新数据,这里用AOP是否可行？**/
        int data = 0;
        int code = 0;
        String msg = "成功";

//        让老数据失效
        data = userService.updateUser(user);
//        插入新数据  aop是否可行？
        data = userService.insertNewUser(user);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(int userId) {
        /**删除用户**/
        int data = 0;
        int code = 0;
        String msg = "成功, sucess";

//        在团队成员表中删除user
        data = userService.deleteUser(userId);

//        将用户的teamId更改为0
        User user = userService.getUser(userId).get(0);
        user.setTeamId(0);
        updateUser(user);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getTeamInfo", method = RequestMethod.GET)
    public String getTeamInfo(Integer teamId, String searchString) {

        HashMap<String, Object> map = new HashMap<>();
        String msg = "成功, success";

        map.put("teamId", teamId);
        map.put("searchString", searchString);

        List<Team> teams = teamService.getTeamInfo(map);

        System.out.println(2);

        int code = 0;

        Map tmpResult = ResultUtils.getResult(teams, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/addTeamMember")
    public String addTeamMember(int teamId, int userId, int roleCode) {

        int data = 0;
        int code = 0;
        HashMap<String, Object> map = new HashMap<>();

        map.put("teamId", teamId);
        map.put("userId", userId);
        map.put("roleCode", roleCode);

//        向team_user表插入数据
        data = teamService.addTeamMenmber(map);

//        获取user对象
        List<User> users = userService.getUser(userId);
        User user = users.get(0);

//        更改用户信息,将用户所在团队改为要加入的团队
        user.setTeamId(teamId);
        updateUser(user);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteTeamMember")
    public String deleteTeamMember(int teamId, Integer userId) {

        int data = 0;
        int code = 0;
        String msg = "成功, success";
        HashMap<String, Object> map = new HashMap<>();

        map.put("teamId", teamId);
        map.put("userId", userId);


//        向team_user表插入数据
        data = teamService.deleteTeamMember(map);

//        获取user对象
        List<User> users = userService.getUser(userId);
        for (User user : users) {
//          更改用户信息,将用户所在团队改为要加入的团队
            user.setTeamId(0);
            updateUser(user);
        }


        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/registerTeam", method = RequestMethod.GET)
    public String registerTeam(TeamRegister team) {

        int data = 0;
        int code = 0;
        String msg = "成功, success";
        int createBy = team.getCreateBy();

        try {
//            注册团队，如果名称重复则抛出异常
            data = teamService.registerTeam(team);
//            获取用户，这里只会返回一条数据，将创建者的团队号码设置成刚刚创建的团队
            List<User> users = userService.getUser(createBy);
            User user = users.get(0);
            user.setTeamId(teamService.getCurTeamId());

            updateUser(user);

//            添加成员
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", user.getUserId());
            map.put("teamId", teamService.getCurTeamId());
//            1表示为管理者
            map.put("roleCode", 1);
            teamService.addTeamMenmber(map);
        } catch (Exception e) {
            msg = "名称已存在，name is already exist";
        }

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteTeam")
    public String deleteTeam(@Param("teamId") int teamId) {

        int data = 0;
        int code = 0;

        data = teamService.deleteTeam(teamId);

//        删除团队的所有成员
        deleteTeamMember(teamId, null);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/publishNotice")
    public String publishNotice(NoticeHeader noticeHeader) {
//接收list参数，参考连接https://www.cnblogs.com/liuwt365/p/7750888.html
//        需要前端，暂不写
//        还需要一个，发送给谁的List参数
        int data = 0;
        int code = 0;
//        创建信息内容
        data = noticeService.createNoticeHeader(noticeHeader);
//        遍历List user_id列表
//        新建map
//        插入信息行分配表

//        结束
        return null;
    }


    @ResponseBody
    @RequestMapping("/receiveNotice")
    public String receiveNotice(@Param("userId") int userId, @Param("noticeId") int noticeId) {

        int data = 0;
        int code = 0;

        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("noticeId", noticeId);

        data = noticeService.receiveNoticeLine(map);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteNotice")
    public String deleteNoticeLine(@Param("userId") int userId, @Param("noticeId") int noticeId) {

        int data = 0, code = 0;

        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("noticeId", noticeId);

        data = noticeService.deleteNoticeLine(map);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);


        return result;
    }


    @ResponseBody
    @RequestMapping("/getNotices")
    public String getNotices(@Param("userId") int userId, String searchString) {

        int code = 0;
        List<NoticeLine> data = null;

        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("searchString", searchString);


        System.out.println(map.get("userId"));
        data = noticeService.getNotices(map);
        System.out.println("sjdlkfajlk");

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/getMyPublishedNotices")
    public String getNoticesCreated(@Param("userId") int createBy) {

        int code = 0;
        List<NoticeHeader> data = null;

        data = noticeService.getNoticesCreated(createBy);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/createArticle")
    public String createArticle(Article article) {

        int date = 0, code = 0;

        int data = articleService.createArticle(article);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/updateArticle")
    public String updateArticle(Article article) {

        int data = 0, code = 0;
        String msg = "成功,sucess";

        data = articleService.updateArticle(article);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteArticle")
    public String deleteArticle(@Param("articleId") int articleId) {

        int date = 0, code = 0;
        String msg = "成功, success";

        int data = articleService.deleteArticle(articleId);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/getArticleComment")
    public String getComment(int articleId) {

        int date = 0, code = 0;

        Comment data = null;

        data = commentService.getComment(articleId);

        Map tmpResult = ResultUtils.getResult(data, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/getSubComment")
    public String getSubComment(@Param("commentId") int commentId) {

        int code = 0;

        List<Comment> comments = null;

        comments = commentService.getSubComment(commentId);

        Map tmpResult = ResultUtils.getResult(comments, code);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/doComment")
    public String doComment(@Param("comment") Comment comment) {

        int data = 0, code = 0;
        String msg = "成功, success";


        data = commentService.doComment(comment);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteComment")
    public String deleteComment(@Param("commentId") int commentId) {

        int data = 0, code = 0;
        String msg = "成功, success";


        data = commentService.deleteComment(commentId);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping("/getTeamMember")
    public String getTeamMember(int teamId) {

        int code = 0;
        String msg = "成功, success";
        List<User> data = null;

        data = teamService.getTeamMember(teamId);

        Map tmpResult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


}