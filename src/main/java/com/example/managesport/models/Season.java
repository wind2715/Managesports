package com.example.managesport.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "muagiai")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMuaGiai;

    @Column(name = "ten_mua_giai", nullable = false)
    private String tenMuaGiai;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "so_doi_tham_du")
    private Integer soDoiThamDu;

    @Column(name = "vi_tri_xuong_hang")
    private Integer viTriXuongHang;

    @Column(name = "vi_tri_du_c1")
    private Integer viTriDuC1;

    @Column(name = "vi_tri_du_c2")
    private Integer viTriDuC2;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<Round> rounds;
}
