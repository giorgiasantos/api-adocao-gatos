package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.mappers.AdocaoMapper;
import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.dtos.AdocaoDTO;
import com.example.catalisa.miaumatch.model.dtos.AdocaoDTOView;
import com.example.catalisa.miaumatch.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {
    @Autowired
    AdocaoRepository adocaoRepository;


    public List<AdocaoDTOView> getAll(){
        List<AdocaoModel> adocoes = adocaoRepository.findAll();
        List<AdocaoDTOView> adocoesDTO = new ArrayList<>();

        for(AdocaoModel adocao : adocoes){
            adocoesDTO.add(new AdocaoDTOView(adocao));
        }

        return adocoesDTO;
    }

    public Optional<AdocaoDTOView> getById(Long id){
        Optional<AdocaoModel> adocao = adocaoRepository.findById(id);

        if(adocao.isPresent()) return Optional.of(new AdocaoDTOView(adocao.get()));

        return Optional.empty();
    }

    public AdocaoDTO cadastrar (AdocaoDTO adocaoDTO){
        AdocaoModel novaAdocao = AdocaoMapper.INSTANCE.adocaoDTOToAdocaoModel(adocaoDTO);
        adocaoRepository.save(novaAdocao);

        return new AdocaoDTO(novaAdocao);
    }

    public AdocaoModel alterar (Long id, AdocaoModel adocaoModel){

        AdocaoModel adocao = adocaoRepository.findById(id).get();

        if(adocao != null){
            adocao.setUser(adocaoModel.getUser());
        }
        if(adocao != null){
            adocao.setData(adocaoModel.getData());
        }
        if(adocao != null){
            adocao.setGato(adocaoModel.getGato());
        }

        return adocaoRepository.save(adocao);
    }

    public void deletar (Long id){
        adocaoRepository.deleteById(id);
    }

}
