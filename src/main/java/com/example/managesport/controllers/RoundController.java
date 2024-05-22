package com.example.managesport.controllers;

import com.example.managesport.dtos.RoundDTO;
import com.example.managesport.models.Round;
import com.example.managesport.services.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rounds")
@RequiredArgsConstructor
public class RoundController {

    private final RoundService roundService;

    @PostMapping("")
    public ResponseEntity<Round> createRound(@RequestBody RoundDTO roundDTO) {
        Round createdRound = roundService.createRound(roundDTO);
        return new ResponseEntity<>(createdRound, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Round>> getAllRounds() {
        List<Round> rounds = roundService.getAllRounds();
        return new ResponseEntity<>(rounds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Round> getRoundById(@PathVariable("id") Long id) {
        Round round = roundService.getRoundById(id);
        if (round != null) {
            return new ResponseEntity<>(round, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Round> updateRound(@PathVariable("id") Long id, @RequestBody RoundDTO roundDTO) {
        Round updatedRound = roundService.updateRound(id, roundDTO);
        if (updatedRound != null) {
            return new ResponseEntity<>(updatedRound, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable("id") Long id) {
        roundService.deleteRound(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
