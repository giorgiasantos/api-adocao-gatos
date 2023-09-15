package com.example.catalisa.miaumatch.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ADOCOES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adocao;
    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;

    @ManyToMany
    @JoinTable(
            name = "adocao_gato",
            joinColumns = @JoinColumn(name = "id_adocao"),
            inverseJoinColumns = @JoinColumn(name = "id_gato")
    )
    private List<GatoModel> gatos = new ArrayList<>();

}
