package com.example.managesport.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.Date;
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {
    @JsonProperty("ten_mua_giai")
    private String tenMuaGiai;

    @JsonProperty("ngay_bat_dau")
    private Date ngayBatDau;

    @JsonProperty("ngay_ket_thuc")
    private Date ngayKetThuc;

    @JsonProperty("so_doi_tham_du")
    private Integer soDoiThamDu;

    @JsonProperty("vi_tri_xuong_hang")
    private Integer viTriXuongHang;

    @JsonProperty("vi_tri_du_c1")
    private Integer viTriDuC1;

    @JsonProperty("vi_tri_du_c2")
    private Integer viTriDuC2;
}
