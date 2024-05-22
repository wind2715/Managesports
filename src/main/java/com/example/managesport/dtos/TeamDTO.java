package com.example.managesport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TeamDTO {
    @NotEmpty
    @JsonProperty("ten_doi_bong")
    private String tenDoiBong;

    @JsonProperty("san_van_dong")
    private String sanVanDong;

    @JsonProperty("huan_luyen_vien")
    private String huanLuyenVien;

    @JsonProperty("so_cau_thu_nuoc_ngoai")
    private Integer soCauThuNuocNgoai;

    @JsonProperty("anh_dai_dien")
    private String anhDaiDien;

    @JsonProperty("id_mua_giai")
    private Long idMuaGiai;
}
