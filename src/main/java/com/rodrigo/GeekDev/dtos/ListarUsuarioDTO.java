package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.User;

import java.util.ArrayList;
import java.util.List;

public record ListarUsuarioDTO(String id, String name, String email, List<ListarPostUserDto> posts) {

    public ListarUsuarioDTO(User user){
        this(user.getId(), user.getName(), user.getEmail(), new ArrayList<>(user.getPosts().stream().map(ListarPostUserDto::new).toList()));
    }
}
