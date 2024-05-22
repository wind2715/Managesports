package com.example.managesport.services;

import com.example.managesport.dtos.SeasonDTO;
import com.example.managesport.models.Season;
import com.example.managesport.models.Team;
import com.example.managesport.repositories.SeasonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Builder
@Service
@Getter
@Setter
@RequiredArgsConstructor
public class SeasonService implements ISeasonService {
    private final SeasonRepository seasonRepository;
    @Override
    public Season createSeason(SeasonDTO seasonDTO) {
    Season newSeason = Season.builder()
        .tenMuaGiai(seasonDTO.getTenMuaGiai())
        .ngayBatDau(seasonDTO.getNgayBatDau())
        .ngayKetThuc(seasonDTO.getNgayKetThuc())
        .soDoiThamDu(seasonDTO.getSoDoiThamDu())
        .viTriXuongHang(seasonDTO.getViTriXuongHang())
        .viTriDuC1(seasonDTO.getViTriDuC1())
        .viTriDuC2(seasonDTO.getViTriDuC2())
        .build();
    return seasonRepository.save(newSeason);
}


    @Override
    public Season updateSeason(Long id, SeasonDTO seasonDTO) {
        Season existingSeason = seasonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Season not found"));

        existingSeason.setTenMuaGiai(seasonDTO.getTenMuaGiai());
        existingSeason.setNgayBatDau(seasonDTO.getNgayBatDau());
        existingSeason.setNgayKetThuc(seasonDTO.getNgayKetThuc());
        existingSeason.setSoDoiThamDu(seasonDTO.getSoDoiThamDu());
        existingSeason.setViTriXuongHang(seasonDTO.getViTriXuongHang());
        existingSeason.setViTriDuC1(seasonDTO.getViTriDuC1());
        existingSeason.setViTriDuC2(seasonDTO.getViTriDuC2());

        // Lưu mùa giải đã cập nhật vào cơ sở dữ liệu
        return seasonRepository.save(existingSeason);
    }

    @Override
    public void deleteSeason(Long id) {
        // Xóa mùa giải khỏi cơ sở dữ liệu nếu tồn tại
        if (seasonRepository.existsById(id)) {
            seasonRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Season not found");
        }
    }

    @Override
    public Season getSeasonById(Long id) {
        Optional<Season> seasonOptional = seasonRepository.findById(id);
        if (seasonOptional.isPresent()) {
            return seasonOptional.get();
        } else {
            throw new EntityNotFoundException("Team not found with id: " + id);
        }
    }

    @Override
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }
}
