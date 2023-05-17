package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.Post;

public record ListarPostUserDto(String id) {

    public ListarPostUserDto(Post posts){
        this(posts.getId());
    }
}
