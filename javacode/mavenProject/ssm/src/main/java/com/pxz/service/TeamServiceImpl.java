package com.pxz.service;

import com.pxz.dao.TeamMapper;
import com.pxz.pojo.Team;
import com.pxz.pojo.TeamRegister;
import com.pxz.pojo.User;

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
    public int registerTeam(TeamRegister team) {
        return teamMapper.registerTeam(team);
    }

    @Override
    public int deleteTeam(int teamId) {
        return teamMapper.deleteTeam(teamId);
    }

    @Override
    public int getCurTeamId() {
        return teamMapper.getCurTeamId();
    }

    @Override
    public List<User> getTeamMember(int teamId) {
        return teamMapper.getTeamMember(teamId);
    }

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
}
