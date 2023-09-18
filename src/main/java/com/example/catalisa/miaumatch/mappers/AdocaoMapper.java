package com.example.catalisa.miaumatch.mappers;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.dtos.AdocaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdocaoMapper {

    AdocaoMapper INSTANCE = Mappers.getMapper(AdocaoMapper.class);

    @Mapping(target = "id_adocao", ignore = true)
    AdocaoModel adocaoDTOToAdocaoModel(AdocaoDTO adocaoDTO);

}
