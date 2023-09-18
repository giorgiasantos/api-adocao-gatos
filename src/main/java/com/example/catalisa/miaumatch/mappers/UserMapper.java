package com.example.catalisa.miaumatch.mappers;

import com.example.catalisa.miaumatch.model.UserModel;
import com.example.catalisa.miaumatch.model.dtos.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id_user", ignore = true)
    UserModel userDTOToUserModel(UserDTO userDTO);
}
