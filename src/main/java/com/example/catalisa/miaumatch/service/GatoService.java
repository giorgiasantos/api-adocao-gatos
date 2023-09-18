package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.model.GatoModel;
import com.example.catalisa.miaumatch.repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GatoService {
    @Autowired
    GatoRepository gatoRepository;

    public List<GatoModel> getAll(){
        return gatoRepository.findAll();
    }

    public Optional<GatoModel> getById(Long id){
        Optional<GatoModel> gato = gatoRepository.findById(id);

        if(gato.isPresent()) return gato;

        return Optional.empty();
    }

    public Optional<List<GatoModel>> getByName(String nome){

        Optional<List<GatoModel>> gato = gatoRepository.findByName(nome);

        if(gato.isPresent()) return gato;

        return Optional.empty();

    }

    public GatoModel cadastrar (GatoModel gatoModel){
        return gatoRepository.save(gatoModel);
    }

    public GatoModel alterar (Long id, GatoModel gatoModel){
        GatoModel gato = gatoRepository.findById(id).get();

        if(gato != null){
            gato.setNome(gatoModel.getNome());
        }
        if(gato != null){
            gato.setIdade(gatoModel.getIdade());
        }
        if(gato != null){
            gato.setSexo(gatoModel.getSexo());
        }
        if(gato != null){
            gato.setHistoria(gatoModel.getHistoria());
        }
        if(gato != null){
            gato.setCastrado(gatoModel.isCastrado());
        }
        if(gato != null){
            gato.setUrlFoto(gatoModel.getUrlFoto());
        }

        return gatoRepository.save(gato);
    }

    public void deletar (Long id){
        gatoRepository.deleteById(id);
    }
}
