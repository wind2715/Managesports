package com.example.managesport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO {

    @JsonProperty("ten_vong_dau")
    private String tenVongDau;

    @JsonProperty("id_mua_giai")
    private Long idMuaGiai;

    // Constructors, getters, setters
}

