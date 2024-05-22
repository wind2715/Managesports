package com.example.managesport.services;

import com.example.managesport.dtos.PlayerDTO;
import com.example.managesport.models.Player;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPlayerService {
    List<Player> getAllPlayers();
    Player getPlayerById(Long id);
    Player createPlayer(PlayerDTO playerDTO);
    Player updatePlayer(Long id, PlayerDTO playerDTO);

    void deletePlayer(Long id);
}
