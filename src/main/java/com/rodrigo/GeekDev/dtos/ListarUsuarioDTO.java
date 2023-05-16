package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.User;

public record ListarUsuarioDTO(String id, String name, String email) {

    public ListarUsuarioDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
