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
public class PlayerDTO {
    @NotEmpty
    @JsonProperty("ten_cau_thu")
    private String tenCauThu;

    @JsonProperty("loai_cau_thu")
    private String loaiCauThu;

    @JsonProperty("quoc_tich")
    private String quocTich;

    @JsonProperty("ngay_sinh")
    private Date ngaySinh;

    @JsonProperty("so_ban_thang")
    private int soBanThang;

    @JsonProperty("so_kien_tao")
    private int soKienTao;

    @JsonProperty("so_the_vang")
    private int soTheVang;

    @JsonProperty("so_the_do")
    private int soTheDo;

    @JsonProperty("so_tran_giu_sach_luoi")
    private int soTranGiuSachLuoi;

    @JsonProperty("vi_tri_thi_dau")
    private String viTriThiDau;

    @JsonProperty("id_doi_bong")
    private Long idDoiBong;
}

