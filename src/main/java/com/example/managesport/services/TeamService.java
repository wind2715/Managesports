package com.example.managesport.services;
import com.example.managesport.dtos.TeamDTO;
import com.example.managesport.models.Season;
import com.example.managesport.models.Team;
import com.example.managesport.repositories.SeasonRepository;
import com.example.managesport.repositories.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;
    private final SeasonRepository seasonRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            return teamOptional.get();
        } else {
            throw new EntityNotFoundException("Team not found with id: " + id);
        }
    }
    @Override
    public Team createTeam(TeamDTO teamDTO) {
        Season existingSeason = seasonRepository.findById(teamDTO.getIdMuaGiai())
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    Team newTeam = Team.builder()
            .tenDoiBong(teamDTO.getTenDoiBong())
            .sanVanDong(teamDTO.getSanVanDong())
            .huanLuyenVien(teamDTO.getHuanLuyenVien())
            .soCauThuNuocNgoai(teamDTO.getSoCauThuNuocNgoai())
            .anhDaiDien(teamDTO.getAnhDaiDien())
            .season(existingSeason)
            .build();
    return teamRepository.save(newTeam);
}
    @Override
    public Team updateTeam(Long id, TeamDTO teamDTO) {

        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team existingTeam = teamOptional.get();
            existingTeam.setTenDoiBong(teamDTO.getTenDoiBong());
            existingTeam.setSanVanDong(teamDTO.getSanVanDong());
            existingTeam.setHuanLuyenVien(teamDTO.getHuanLuyenVien());
            existingTeam.setSoCauThuNuocNgoai(teamDTO.getSoCauThuNuocNgoai());
            return teamRepository.save(existingTeam);
        } else {
            throw new EntityNotFoundException("Team not found with id: " + id);
        }
}


    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
