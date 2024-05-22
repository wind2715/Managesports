package com.example.managesport.services;

import com.example.managesport.dtos.MatchDTO;
import com.example.managesport.models.Match;

import java.util.List;

public interface IMatchService {
    List<Match> getAllMatches();
    Match getMatchById(Long id);
    Match createMatch(MatchDTO matchDTO);
    Match updateMatch(Long id, MatchDTO matchDTO);
    void deleteMatch(Long id);
}

