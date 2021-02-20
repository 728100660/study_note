package com.pxz.dao;

import com.pxz.pojo.Team;
import com.pxz.pojo.TeamRegister;
import com.pxz.pojo.User;

import java.util.List;
import java.util.Map;

public interface TeamMapper {

    List<Team> getTeamInfo(Map<String,Object> map);

//    传参：userId,和roleCode,teamId
    int addTeamMenmber(Map<String,Object> map);

//    传参：userId,teamId,userId可以为空，
//    当userId为空时，删除该团队所有成员（一般在注销团队的时候使用）
    int deleteTeamMember(Map<String,Object> map);

    int registerTeam(TeamRegister team);

    int deleteTeam(int teamId);
//     获取当前团队id序列号
    int getCurTeamId();
//      获取团队成员
    List<User> getTeamMember(int teamId);
}
