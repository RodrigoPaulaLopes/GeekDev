package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.User;

public record InserirUsuarioDto(String name, String email) {

    public InserirUsuarioDto(User user){
        this(user.getName(), user.getEmail());
    }
}
