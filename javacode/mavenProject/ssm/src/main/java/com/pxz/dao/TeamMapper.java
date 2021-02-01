package com.pxz.dao;

import com.pxz.pojo.Team;

import java.util.List;
import java.util.Map;

public interface TeamMapper {

    List<Team> getTeamInfo(Map<String,Object> map);

//    传参：userId,和roleCode,teamId
    int addTeamMenmber(Map<String,Object> map);

//    传参：userId,teamId,userId可以为空，
//    当userId为空时，删除该团队所有成员（一般在注销团队的时候使用）
    int deleteTeamMember(Map<String,Object> map);

    int registerTeam(Team team);

    int deleteTeam(int teamId);
}
