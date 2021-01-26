package com.pxz.service;

import com.pxz.dao.TeamMapper;
import com.pxz.pojo.Team;

import java.util.List;

public class TeamServiceImpl implements TeamService{

    private TeamMapper teamMapper;

    @Override
    public List<Team> getTeamInfo(int teamId) {
        System.out.println(teamId);
        return teamMapper.getTeamInfo(teamId);
    }

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
}
