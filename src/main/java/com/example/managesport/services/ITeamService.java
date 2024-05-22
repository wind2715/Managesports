package com.example.managesport.services;

import com.example.managesport.dtos.TeamDTO;
import com.example.managesport.models.Team;

import java.util.List;

public interface ITeamService {
    List<Team> getAllTeams();

    Team getTeamById(Long id);

    Team createTeam(TeamDTO teamDTO);

    Team updateTeam(Long id, TeamDTO teamDTO);

    void deleteTeam(Long id);
}
