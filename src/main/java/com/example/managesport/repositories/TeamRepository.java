package com.example.managesport.repositories;

import com.example.managesport.dtos.TeamDTO;
import com.example.managesport.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Các phương thức tùy chỉnh nếu cần
    List<Team> findByIdMuaGiai(Long idMuaGiai);
}
