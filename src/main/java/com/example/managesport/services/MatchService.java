package com.example.managesport.services;

import com.example.managesport.dtos.MatchDTO;
import com.example.managesport.models.Match;
import com.example.managesport.models.Round;
import com.example.managesport.models.Team;
import com.example.managesport.repositories.MatchRepository;
import com.example.managesport.repositories.RoundRepository;
import com.example.managesport.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService implements IMatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final RoundRepository roundRepository;

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {
        Team homeTeam = teamRepository.findById(matchDTO.getHomeTeamId())
                .orElseThrow(() -> new RuntimeException("Home team not found"));

        Team awayTeam = teamRepository.findById(matchDTO.getAwayTeamId())
                .orElseThrow(() -> new RuntimeException("Away team not found"));

        Round round = roundRepository.findById(matchDTO.getRoundId())
                .orElseThrow(() -> new RuntimeException("Round not found"));

        Match newMatch = Match.builder()
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .stadium(matchDTO.getStadium())
                .homeGoals(matchDTO.getHomeGoals())
                .awayGoals(matchDTO.getAwayGoals())
                .round(round)
                .build();

        return matchRepository.save(newMatch);
    }

    @Override
    public Match updateMatch(Long id, MatchDTO matchDTO) {
        return null;
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
