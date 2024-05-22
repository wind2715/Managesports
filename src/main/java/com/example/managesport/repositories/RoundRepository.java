package com.example.managesport.repositories;

import com.example.managesport.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {
    // Các phương thức tùy chỉnh có thể được thêm vào đây nếu cần
}
