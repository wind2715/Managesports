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
@Table(name = "cauthu")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCauThu;

    @Column(name = "ten_cau_thu", nullable = false)
    private String tenCauThu;

    @Column(name = "loai_cau_thu")
    private String loaiCauThu;

    @Column(name = "quoc_tich", length = 100)
    private String quocTich;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "so_ban_thang")
    private Integer soBanThang;

    @Column(name = "so_kien_tao")
    private Integer soKienTao;

    @Column(name = "so_the_vang")
    private Integer soTheVang;

    @Column(name = "so_the_do")
    private Integer soTheDo;

    @Column(name = "so_tran_giu_sach_luoi")
    private Integer soTranGiuSachLuoi;

    @Column(name = "vi_tri_thi_dau")
    private String viTriThiDau;

    @ManyToOne
    @JoinColumn(name = "id_doi_bong")
    @JsonIgnore
    private Team team;
}
