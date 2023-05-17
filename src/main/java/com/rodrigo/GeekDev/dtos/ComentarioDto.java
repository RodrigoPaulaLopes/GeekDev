package com.rodrigo.GeekDev.dtos;

import java.time.Instant;

public record ComentarioDto(String text, Instant data, AuthorDto author) {


}
