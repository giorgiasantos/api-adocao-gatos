package com.example.catalisa.miaumatch.controller;

import com.example.catalisa.miaumatch.mappers.UserMapper;
import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.model.dtos.UserDTO;
import com.example.catalisa.miaumatch.model.dtos.UserDTOView;
import com.example.catalisa.miaumatch.service.UserService;
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

@Tag(name = "users")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Lista todos os usuários. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<UserDTOView> listarTodos(){
        return userService.getAll();
    }

    @Operation(summary = "Busca um usuário por ID. ", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/buscaId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<UserDTOView> user = userService.getById(id);

        if(user.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! Usuário não encontrado. ");

        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Cadastra um novo usuário. ", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> cadastrar (@RequestBody UserDTO userDTO){
        UserModel novoUser = UserMapper.INSTANCE.userDTOToUserModel(userDTO);
        UserDTO novoUserDTO = userService.cadastrar(new UserDTO(novoUser));

        return ResponseEntity.ok().body("Oba!  Cadastro realizado com sucesso! " );
    }

    @Operation(summary = "Altera o cadastro de um usuário. ", method = "PUT")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> alterar (@PathVariable Long id, @RequestBody UserModel userModel){

        UserModel user = userService.alterar(id,userModel);

        if(user != null) return ResponseEntity.ok("Cadastro alterado com sucesso! ");

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deleta o cadastro de um usuário. ", method = "DELETE")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletar (@PathVariable Long id){
        userService.deletar(id);
    }

}
