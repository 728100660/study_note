package com.pxz.dao;

import com.pxz.pojo.Team;

import java.util.List;

public interface TeamMapper {

    List<Team> getTeamInfo(int teamId);
}
