package com.example.managesport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "vongdau")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vong_dau")
    private Long idVongDau;

    @Column(name = "ten_vong_dau", nullable = false)
    private String tenVongDau;

    @ManyToOne
    @JoinColumn(name = "id_mua_giai")
    @JsonIgnore
    private Season season;

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    private List<Match> matches;
    // Constructors, getters, setters
}