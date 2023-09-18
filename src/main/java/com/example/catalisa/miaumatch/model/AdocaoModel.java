package com.example.catalisa.miaumatch.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


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

    @OneToOne
    @JoinColumn(name = "gato_id")
    private GatoModel gato;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

}
