package com.example.managesport.services;

import com.example.managesport.models.Player;
import com.example.managesport.models.Team;
import com.example.managesport.repositories.PlayerRepository;
import com.example.managesport.dtos.PlayerDTO;
import com.example.managesport.repositories.TeamRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Data
@Builder
@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        Team existingTeam = teamRepository.findById(playerDTO.getIdDoiBong())
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        Player newPlayer = Player.builder()
                .tenCauThu(playerDTO.getTenCauThu())
                .loaiCauThu(playerDTO.getLoaiCauThu())
                .quocTich(playerDTO.getQuocTich())
                .ngaySinh(playerDTO.getNgaySinh())
                .soBanThang(playerDTO.getSoBanThang())
                .soKienTao(playerDTO.getSoKienTao())
                .soTheVang(playerDTO.getSoTheVang())
                .soTheDo(playerDTO.getSoTheDo())
                .soTranGiuSachLuoi(playerDTO.getSoTranGiuSachLuoi())
                .viTriThiDau(playerDTO.getViTriThiDau())
                .team(existingTeam)
                .build();
        return playerRepository.save(newPlayer);
}


    @Override
public Player updatePlayer(Long id, PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findById(id);
    if (playerOptional.isPresent()) {
        Player player = playerOptional.get();
        // Cập nhật thông tin của cầu thủ từ PlayerDTO
        player.setTenCauThu(playerDTO.getTenCauThu());
        player.setLoaiCauThu(playerDTO.getLoaiCauThu());
        player.setQuocTich(playerDTO.getQuocTich());
        player.setNgaySinh(playerDTO.getNgaySinh());
        player.setSoBanThang(playerDTO.getSoBanThang());
        player.setSoKienTao(playerDTO.getSoKienTao());
        player.setSoTheVang(playerDTO.getSoTheVang());
        player.setSoTheDo(playerDTO.getSoTheDo());
        player.setSoTranGiuSachLuoi(playerDTO.getSoTranGiuSachLuoi());
        player.setViTriThiDau(playerDTO.getViTriThiDau());

        return playerRepository.save(player);
    } else {
        return null;
    }
}

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
