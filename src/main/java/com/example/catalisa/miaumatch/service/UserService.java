package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.mappers.UserMapper;
import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.model.dtos.UserDTO;
import com.example.catalisa.miaumatch.model.dtos.UserDTOView;
import com.example.catalisa.miaumatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTOView> getAll(){
        List<UserModel> users = userRepository.findAll();
        List<UserDTOView> usersDTO = new ArrayList<>();

        for(UserModel user: users){
            usersDTO.add(new UserDTOView(user));
        }

        return usersDTO;
    }

    public Optional<UserDTOView> getById(Long id){

        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent()) return Optional.of(new UserDTOView(user.get()));

        return Optional.empty();
    }

    public UserDTO cadastrar (UserDTO userDTO){
        UserModel novoUser = UserMapper.INSTANCE.userDTOToUserModel(userDTO);
        userRepository.save(novoUser);
        return new UserDTO(novoUser);
    }

    public UserModel alterar (Long id, UserModel userModel){
        UserModel user = userRepository.findById(id).get();

        if(user != null){
            user.setPassword(userModel.getPassword());
        }
        if(user != null){
            user.setTelefone(userModel.getTelefone());
        }
        if(user != null){
            user.setNome(userModel.getNome());
        }

        return userRepository.save(user);
    }

    public void deletar (Long id){
        userRepository.deleteById(id);
    }

}
