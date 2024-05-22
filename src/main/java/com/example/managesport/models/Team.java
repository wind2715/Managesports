package com.example.managesport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"homeMatches", "awayMatches"})
@Table(name = "doibong")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doi_bong")
    private Long idDoiBong;

    @Column(name = "ten_doi_bong", nullable = false)
    private String tenDoiBong;

    @Column(name = "san_van_dong")
    private String sanVanDong;

    @Column(name = "huan_luyen_vien")
    private String huanLuyenVien;

    @Column(name = "so_cau_thu_nuoc_ngoai")
    private Integer soCauThuNuocNgoai;

    @Column(name = "anh_dai_dien")
    private String anhDaiDien;

    @Column(name = "id_mua_giai", insertable = false, updatable = false)
    private Long idMuaGiai;

    @ManyToOne
    @JoinColumn(name = "id_mua_giai")
    @JsonIgnore
    private Season season;



    // Mối quan hệ một-nhiều với cầu thủ (một đội có nhiều cầu thủ)
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL)
    private List<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL)
    private List<Match> awayMatches;
}
