package com.blogen.user.controller;

import com.blogen.auth.Role;
import com.blogen.auth.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

class UserMapper {

    private final ModelMapper mapper;

    UserMapper() {
        mapper = new ModelMapper();
        mapper.addConverter(convertStringToRoleEnum);
    }

    UserDTO toDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    User toEntity(UserDTO userDTO) {
        //mapper.addConverter(convertStringToRoleEnum);
        return mapper.map(userDTO, User.class);
    }

    private static Converter<String, Role> convertStringToRoleEnum =
            new AbstractConverter<String, Role>() {
                protected Role convert(String stringRole) {
                    return Role.valueOf(stringRole);
                }
            };
}
