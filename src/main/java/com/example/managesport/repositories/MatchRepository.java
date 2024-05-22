package com.example.managesport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.managesport.models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Các phương thức tùy chỉnh có thể được thêm ở đây nếu cần
}
