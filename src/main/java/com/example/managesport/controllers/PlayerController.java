package com.example.managesport.controllers;

import com.example.managesport.models.Player;
import com.example.managesport.dtos.PlayerDTO;
import com.example.managesport.services.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@Validated
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("")
    public ResponseEntity<?> createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        playerService.createPlayer(playerDTO);
        return ResponseEntity.ok("Successfully");
    }
    @GetMapping("")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") Long id, @RequestBody PlayerDTO playerDTO) {
        Player updatedPlayer = playerService.updatePlayer(id, playerDTO);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
