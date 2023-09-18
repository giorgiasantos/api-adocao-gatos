package com.example.catalisa.miaumatch.model.dtos;

import com.example.catalisa.miaumatch.model.RoleModel;
import com.example.catalisa.miaumatch.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String nome;
    private String telefone;
    private List<RoleModel> roles;

    public UserDTO(UserModel userModel) {
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();
        this.nome = userModel.getNome();
        this.telefone = userModel.getTelefone();
        this.roles = userModel.getRoles();
    }
}
