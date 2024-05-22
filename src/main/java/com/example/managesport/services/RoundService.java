package com.example.managesport.services;

import com.example.managesport.dtos.RoundDTO;
import com.example.managesport.models.Round;
import com.example.managesport.models.Season;
import com.example.managesport.repositories.RoundRepository;
import com.example.managesport.repositories.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundService implements IRoundService {

    private final RoundRepository roundRepository;
    private final SeasonRepository seasonRepository;

    @Override
    public Round createRound(RoundDTO roundDTO) {
        Season existingSeason = seasonRepository.findById(roundDTO.getIdMuaGiai())
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    Round newRound = Round.builder()
            .tenVongDau(roundDTO.getTenVongDau())
            .season(existingSeason)
            .build();
    return roundRepository.save(newRound);
    }

    @Override
    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    @Override
    public Round getRoundById(Long id) {
        return roundRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }
    @Override
    public Round updateRound(Long id, RoundDTO roundDTO) {
        Round existingRound = roundRepository.findById(id).orElse(null);
        if (existingRound != null) {
            existingRound.setTenVongDau(roundDTO.getTenVongDau());
            return roundRepository.save(existingRound);
        } else {
            return null;
        }
    }
}
