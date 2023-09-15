package com.example.catalisa.miaumatch.controller;

import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<UserModel> listarTodos(){
        return userService.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/buscaId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<UserModel> user = userService.getById(id);

        if(user.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ops! Usuário não encontrado. ");

        return ResponseEntity.ok().body(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> cadastrar (@RequestBody UserModel userModel){
        UserModel user = userService.cadastrar(userModel);

        return ResponseEntity.ok().body("Oba!  Cadastro realizado com sucesso! " );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> alterar (@PathVariable Long id, @RequestBody UserModel userModel){

        UserModel user = userService.alterar(id,userModel);

        if(user != null) return ResponseEntity.ok("Cadastro alterado com sucesso! ");

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletar (@PathVariable Long id){
        userService.deletar(id);
    }

}
