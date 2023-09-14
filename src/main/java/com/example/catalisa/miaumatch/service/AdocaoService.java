package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.GatoModel;
import com.example.catalisa.miaumatch.repository.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {
    @Autowired
    AdocaoRepository adocaoRepository;

    public List<AdocaoModel> getAll(){
        return adocaoRepository.findAll();
    }

    public Optional<AdocaoModel> getById(Long id){
        Optional<AdocaoModel> adocao = adocaoRepository.findById(id);

        if(adocao.isPresent()) return adocao;

        return Optional.empty();
    }

    public AdocaoModel cadastrar(AdocaoModel adocaoModel){
        return adocaoRepository.save(adocaoModel);
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
            adocao.setGatos(adocaoModel.getGatos());
        }

        return adocaoRepository.save(adocao);
    }

    public void deletar (Long id){
        adocaoRepository.deleteById(id);
    }

}
