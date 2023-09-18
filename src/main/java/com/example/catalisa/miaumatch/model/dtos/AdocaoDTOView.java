package com.example.catalisa.miaumatch.model.dtos;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.GatoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class AdocaoDTOView implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id_adocao;
    private LocalDate data;
    private GatoModel gato;

    public AdocaoDTOView (AdocaoModel adocaoModel){
        this.id_adocao = adocaoModel.getId_adocao();
        this.data = adocaoModel.getData();
        this.gato = adocaoModel.getGato();
    }

}
