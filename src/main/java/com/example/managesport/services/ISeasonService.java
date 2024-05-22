package com.example.managesport.services;

import com.example.managesport.dtos.SeasonDTO;
import com.example.managesport.models.Season;

import java.util.List;

public interface ISeasonService {
    Season createSeason(SeasonDTO seasonDTO);
    Season updateSeason(Long id, SeasonDTO seasonDTO);
    void deleteSeason(Long id);
    Season getSeasonById(Long id);
    List<Season> getAllSeasons();
}
