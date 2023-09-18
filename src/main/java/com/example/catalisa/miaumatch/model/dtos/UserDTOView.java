package com.example.catalisa.miaumatch.model.dtos;

import com.example.catalisa.miaumatch.model.RoleModel;
import com.example.catalisa.miaumatch.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDTOView implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id_user;
    private String username;
    private String nome;
    private String telefone;
    private List<RoleModel> roles;

    public UserDTOView(UserModel user) {
        this.id_user = user.getId_user();
        this.username = user.getUsername();
        this.nome = user.getNome();
        this.telefone = user.getTelefone();
        this.roles = user.getRoles();
    }
}
