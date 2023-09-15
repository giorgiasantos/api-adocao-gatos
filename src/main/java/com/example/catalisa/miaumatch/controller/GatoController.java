package com.example.catalisa.miaumatch.controller;

import com.example.catalisa.miaumatch.model.GatoModel;
import com.example.catalisa.miaumatch.service.GatoService;
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

@Tag(name = "gatos")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "api/gatos")
public class GatoController {
    @Autowired
    GatoService gatoService;

    @Operation(summary = "Lista todos os gatos. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<GatoModel> listarTodos(){
        return gatoService.getAll();
    }

    @Operation(summary = "Busca um gato por ID. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/buscaId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<GatoModel> gato = gatoService.getById(id);

        if(gato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! O cadastro não foi encontrado.");
        }

        return ResponseEntity.ok().body(gato.get());
    }

    @Operation(summary = "Busca um gato pelo nome. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(path = "/buscaNome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){

        Optional<List<GatoModel>> gato = gatoService.getByName(nome);

        if(gato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! O cadastro não foi encontrado.");
        }

        return ResponseEntity.ok().body(gato.get());
    }

    @Operation(summary = "Cadastra um gato. ", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> criarCadastro(@RequestBody GatoModel gatoModel){

        GatoModel gato = gatoService.cadastrar(gatoModel);

        return ResponseEntity.ok("Oba!  Cadastro realizado com sucesso! ");
    }

    @Operation(summary = "Altera o cadastro de um gato. ", method = "PUT")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> alterarCadastro(@PathVariable Long id, @RequestBody GatoModel gatoModel){
        GatoModel gato = gatoService.alterar(id,gatoModel);

        if(gato != null){
            return ResponseEntity.ok().body("Cadastro alterado com sucesso! ");
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta o cadastro de um gato. ", method = "DELETE")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletar (@PathVariable Long id){
        gatoService.deletar(id);
    }
}
