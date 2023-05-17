package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.User;

public record AuthorDto(String id, String name) {

    public AuthorDto(User user){
        this(user.getId(), user.getName());
    }
}
