package com.example.managesport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trandau")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tran_dau")
    private Long idTranDau;

    @ManyToOne
    @JoinColumn(name = "doi_nha")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "doi_khach")
    private Team awayTeam;

    @Column(name = "san_thi_dau")
    private String stadium;

    @Column(name = "so_ban_thang_chu_nha")
    private Integer homeGoals;

    @Column(name = "so_ban_thang_doi_khach")
    private Integer awayGoals;

    @ManyToOne
    @JoinColumn(name = "id_vong_dau")
    @JsonIgnore
    private Round round;

    // Getters and setters
}
