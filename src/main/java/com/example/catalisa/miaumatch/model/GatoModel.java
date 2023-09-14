package com.example.catalisa.miaumatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "TB_GATOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGato;

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
