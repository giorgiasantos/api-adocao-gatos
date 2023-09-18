package com.example.catalisa.miaumatch.model.dtos;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.GatoModel;
import com.example.catalisa.miaumatch.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Data
public class AdocaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate data;
    private GatoModel gato;
    private UserModel user;

    public AdocaoDTO (AdocaoModel adocaoModel){
        this.data = adocaoModel.getData();
        this.gato = adocaoModel.getGato();
        this.user = adocaoModel.getUser();
    }

}
