package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent()) return user;

        return Optional.empty();
    }

    public UserModel cadastrar (UserModel userModel){
        return userRepository.save(userModel);
    }

    public UserModel alterar (Long id, UserModel userModel){
        UserModel user = userRepository.findById(id).get();

        if(user != null){
            user.setPassword(userModel.getPassword());
        }

        return userRepository.save(user);
    }

    public void deletar (Long id){
        userRepository.deleteById(id);
    }

}
