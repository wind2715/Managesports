package com.example.managesport.controllers;

import com.example.managesport.dtos.SeasonDTO;
import com.example.managesport.models.Season;
import com.example.managesport.services.SeasonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seasons")
@RequiredArgsConstructor
public class SeasonController {

    private final SeasonService seasonService;

    @GetMapping("")
    public ResponseEntity<List<Season>> getAllSeasons() {
        List<Season> seasons = seasonService.getAllSeasons();
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable("id") Long id) {
        Season season = seasonService.getSeasonById(id);
        if (season != null) {
            return new ResponseEntity<>(season, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Season> createSeason(@RequestBody @Valid SeasonDTO seasonDTO) {
        Season createdSeason = seasonService.createSeason(seasonDTO);
        return new ResponseEntity<>(createdSeason, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Season> updateSeason(@PathVariable("id") Long id, @RequestBody @Valid SeasonDTO seasonDTO) {
        Season updatedSeason = seasonService.updateSeason(id, seasonDTO);
        if (updatedSeason != null) {
            return new ResponseEntity<>(updatedSeason, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable("id") Long id) {
        seasonService.deleteSeason(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
