package com.example.managesport.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    @JsonProperty("doi_nha")
    private Long homeTeamId;

    @JsonProperty("doi_khach")
    private Long awayTeamId;

    @JsonProperty("san_thi_dau")
    private String stadium;

    @JsonProperty("so_ban_thang_chu_nha")
    private Integer homeGoals;

    @JsonProperty("so_ban_thang_doi_khach")
    private Integer awayGoals;

    @JsonProperty("id_vong_dau")
    private Long roundId;

    // Getters and setters
}
