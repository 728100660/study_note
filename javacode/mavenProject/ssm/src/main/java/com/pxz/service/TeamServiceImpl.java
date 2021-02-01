package com.pxz.service;

import com.pxz.dao.TeamMapper;
import com.pxz.pojo.Team;

import java.util.List;
import java.util.Map;

public class TeamServiceImpl implements TeamService{

    private TeamMapper teamMapper;

    @Override
    public List<Team> getTeamInfo(Map<String,Object> map) {
        return teamMapper.getTeamInfo(map);
    }

    @Override
    public int addTeamMenmber(Map<String, Object> map) {
        return teamMapper.addTeamMenmber(map);
    }

    @Override
    public int deleteTeamMember(Map<String, Object> map) {
        return teamMapper.deleteTeamMember(map);
    }

    @Override
    public int registerTeam(Team team) {
        return teamMapper.registerTeam(team);
    }

    @Override
    public int deleteTeam(int teamId) {
        return teamMapper.deleteTeam(teamId);
    }

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
}
