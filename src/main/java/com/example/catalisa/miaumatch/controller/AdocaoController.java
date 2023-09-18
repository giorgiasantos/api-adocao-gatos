package com.example.catalisa.miaumatch.controller;

import com.example.catalisa.miaumatch.mappers.AdocaoMapper;
import com.example.catalisa.miaumatch.model.AdocaoModel;
import com.example.catalisa.miaumatch.model.dtos.AdocaoDTO;
import com.example.catalisa.miaumatch.model.dtos.AdocaoDTOView;
import com.example.catalisa.miaumatch.service.AdocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "adocao")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/adocao")

public class AdocaoController {
    @Autowired
    AdocaoService adocaoService;


    @Operation(summary = "Lista todos as as adoções. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<AdocaoDTOView> buscarTodas(){
        return adocaoService.getAll();
    }

    @Operation(summary = "Busca uma adoção por ID. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/buscaId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<AdocaoDTOView> adocaoModel = adocaoService.getById(id);

        if(adocaoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! O cadastro não foi encontrado.");
        }

        return ResponseEntity.ok().body(adocaoModel);
    }

    @Operation(summary = "Cadastra uma nova adoção. ", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> criarCadastro(@RequestBody AdocaoDTO adocaoDTO){

        AdocaoModel novaAdocao = AdocaoMapper.INSTANCE.adocaoDTOToAdocaoModel(adocaoDTO);
        AdocaoDTO novaAdocaoDTO = adocaoService.cadastrar(new AdocaoDTO(novaAdocao));
        return ResponseEntity.ok("Oba!  Cadastro realizado com sucesso! " + novaAdocaoDTO);
    }

    @Operation(summary = "Altera o cadastro de uma adoção. ", method = "PUT")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> alterarCadastro(@PathVariable Long id, @RequestBody AdocaoModel adocaoModel){

        AdocaoModel adocao = adocaoService.alterar(id,adocaoModel);
        if(adocao != null){
            return ResponseEntity.ok().body("Cadastro alterado com sucesso! ");
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta o cadastro de uma adoção. ", method = "DELETE")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletar (@PathVariable Long id){
        adocaoService.deletar(id);
    }

}
