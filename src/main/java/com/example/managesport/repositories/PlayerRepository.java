package com.example.managesport.repositories;

import com.example.managesport.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Thêm các phương thức tùy chỉnh nếu cần thiết
}
