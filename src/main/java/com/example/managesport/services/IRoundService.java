package com.example.managesport.services;

import com.example.managesport.dtos.RoundDTO;
import com.example.managesport.models.Round;

import java.util.List;

public interface IRoundService {

    Round createRound(RoundDTO roundDTO);

    List<Round> getAllRounds();

    Round getRoundById(Long id);

    void deleteRound(Long id);

    Round updateRound(Long id, RoundDTO roundDTO);
}
