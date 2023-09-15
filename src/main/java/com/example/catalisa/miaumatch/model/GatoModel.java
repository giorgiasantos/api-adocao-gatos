package com.example.catalisa.miaumatch.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_GATOS")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gato;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String historia;
    @Column(nullable = false)
    private boolean castrado;
    @Column(nullable = false)
    private boolean disponivelAdocao;
    @Column(nullable = false)
    private String urlFoto;

}
