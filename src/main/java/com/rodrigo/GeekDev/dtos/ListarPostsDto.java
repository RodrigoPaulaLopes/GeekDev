package com.rodrigo.GeekDev.dtos;

import com.rodrigo.GeekDev.domain.Post;

import java.time.Instant;
import java.util.List;

public record ListarPostsDto(String id, Instant date, String title, String body, AuthorDto author, List<ComentarioDto> comentarios) {

    public ListarPostsDto(Post posts){
        this(posts.getId(), posts.getDate(), posts.getTitle(), posts.getBody(), new AuthorDto(posts.getUser()), posts.getComentarios());
    }
}
