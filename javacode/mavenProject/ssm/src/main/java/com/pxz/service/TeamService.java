package com.pxz.service;

import com.pxz.pojo.Team;

import java.util.List;
import java.util.Map;

public interface TeamService {

    List<Team> getTeamInfo(Map<String, Object> map);

    //    传参：userId,和roleCode,teamId
    int addTeamMenmber(Map<String, Object> map);

    //    传参：userId,teamId
    int deleteTeamMember(Map<String, Object> map);

    int registerTeam(Team team);

    int deleteTeam(int teamId);
}
