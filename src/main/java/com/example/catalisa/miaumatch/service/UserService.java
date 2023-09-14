package com.example.catalisa.miaumatch.service;

import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }
}
