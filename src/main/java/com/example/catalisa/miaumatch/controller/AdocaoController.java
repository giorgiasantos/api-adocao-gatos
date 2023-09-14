package com.example.catalisa.miaumatch.controller;

import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.service.AdocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/adocao")

public class AdocaoController {
    @Autowired
    AdocaoService adocaoService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<AdocaoModel> buscarTodas(){
        return adocaoService.getAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/buscaId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<AdocaoModel> adocaoModel = adocaoService.getById(id);

        if(adocaoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! O cadastro não foi encontrado.");
        }

        return ResponseEntity.ok().body(adocaoModel.get());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> criarCadastro(@RequestBody AdocaoModel adocaoModel){

        AdocaoModel adocao = adocaoService.cadastrar(adocaoModel);

        return ResponseEntity.ok("Oba!  Cadastro realizado com sucesso! ");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> alterarCadastro(@PathVariable Long id, @RequestBody AdocaoModel adocaoModel){

        AdocaoModel adocao = adocaoService.alterar(id,adocaoModel);
        if(adocao != null){
            return ResponseEntity.ok().body("Cadastro alterado com sucesso! ");
        }

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletar (@PathVariable Long id){
        adocaoService.deletar(id);
    }

}
