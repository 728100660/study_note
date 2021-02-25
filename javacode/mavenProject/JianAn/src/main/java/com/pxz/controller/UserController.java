package com.pxz.controller;

import com.pxz.pojo.*;
import com.pxz.service.*;
import com.pxz.utils.JsonUtils;
import com.pxz.utils.ResultUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller//让该类被spring扫描
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

    @Autowired
    @Qualifier("PlaceServiceImpl")
    private PlaceServiceImpl placeService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(Integer teamId) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(name = "school") String school, @RequestParam(name = "identity_id") String count, String password) {
        /**   登录   **/
        int code = 1; //方法的返回状态，1为成功，0 为失败
        String msg;
        HashMap<String, Object> map = new HashMap<>();
        map.put("school", school);
        map.put("password", password);
        map.put("count", count);

        Integer userId = userService.login(map);

        code = userId == null ? 0 : 1;//userId为null的时候说明登录失败，账号或者密码错误
        msg = code == 0 ? "账号或者密码错误" : "登录成功";

//        HashMap<String, Object> data = new HashMap<>();
//        data.put("userId", userId);

        Map tmpResult = ResultUtils.getResult(userId, code, msg);

        String result = JsonUtils.getJson(tmpResult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/get_user_info", method = RequestMethod.GET)
    public String get_user_info(@RequestParam("user_id") int userId) {
        /**   获取用户信息   **/

        int code = 1;
        User user = null;
        String msg = "成功, success";

        user = userService.getUser(userId);

        Map tmpresult = ResultUtils.getResult(user, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/sent_notify", method = RequestMethod.GET)
    public String sent_notify(String title, String content, @RequestParam("user_id") int userId) {
        /**   第一次登录绑定微信号   **/

        int code = 1, data = 0;
        String msg = "成功, success";

        HashMap<String, Object> map = new HashMap<>();

        map.put("title", title);
        map.put("content", content);
        map.put("user_id", userId);

        data = noticeService.createNotice(map);

        Map tmpresult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/set_status", method = RequestMethod.GET)
    public String setStatus(String place, String state, @RequestParam("user_id") int userId) {
        /**   设置场所状态，涉及到权限处理   **/

        int code = 1, data = 0;
        String msg = "成功, success";

        HashMap<String, Object> map = new HashMap<>();
        map.put("place", place);
        map.put("state", state);

        data = placeService.setStatus(map);

        Map tmpresult = ResultUtils.getResult(data, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/get_notify", method = RequestMethod.GET)
    public String getNotice(@RequestParam("user_id") int userId) {
        /**   设置场所状态，涉及到权限处理   **/

        int code = 1;
        String msg = "成功, success";

        List<Notice> notices = noticeService.getNotices();

        Map tmpresult = ResultUtils.getResult(notices, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/get_place", method = RequestMethod.GET)
    public String getPlace(@RequestParam("authority") int authority) {
        /**   获取自己所管理的场所，涉及权限  **/

        int code = 1;
        String msg = "成功, success";

        List<Place> place = placeService.getPlace();

        Map tmpresult = ResultUtils.getResult(place, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/get_ab_info", method = RequestMethod.GET)
    public String getAcademyBuildInfo() {
        /**   获取教学楼信息  **/

        int code = 1;
        String msg = "成功, success";

        List<AcademyBuild> buildInfo = placeService.getAcademyBuildInfo(null);

        Map tmpresult = ResultUtils.getResult(buildInfo, code, msg);

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/get_number", method = RequestMethod.GET)
    public String getNumber(String place, String flag, String floor) {
        /**   获取场所人数  **/

        int code = 1;
        String msg = "成功, success";
        Map tmpresult = null;

//        如果 没有传递flag 标记，则将所有场所人数返回
        if(flag != null){
            List<Place> placesNumber = placeService.getPlace();
            tmpresult = ResultUtils.getResult(placesNumber, code);
        }else if(floor != null){
//            只会获得一个结果
            List<AcademyBuild> buildInfos = placeService.getAcademyBuildInfo(place);
            AcademyBuild build = buildInfos.get(0);

            String[] indexs = build.getIndex().split("_");

            List<ClassRoomNumber> classRoomNumber = null;
            for(String index:indexs){
                String temp_index = index + floor;
                classRoomNumber = placeService.getClassRoomNumber(temp_index);
            }

            tmpresult = ResultUtils.getResult(classRoomNumber, code);
        }

        String result = JsonUtils.getJson(tmpresult);

        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public String doAppointment() {
        /**   预约校医院  **/

        int code = 1;
        String msg = "成功, success";

        Jedis jedis = new Jedis("112.74.103.24",6379);

        jedis.set("name","pxz");

        System.out.println(jedis.get("name"));

//        List<AcademyBuild> buildInfo = placeService.getAcademyBuildInfo(null);
//
//        Map tmpresult = ResultUtils.getResult(buildInfo, code, msg);
//
//        String result = JsonUtils.getJson(tmpresult);

//        return result;
        return null;
    }

}