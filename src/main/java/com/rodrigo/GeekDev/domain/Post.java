package com.rodrigo.GeekDev.domain;

import com.rodrigo.GeekDev.dtos.ComentarioDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "post")
public class Post {
    public Post(Instant date, String title, String body, User user){
        this.setDate(date);
        this.setTitle(title);
        this.setBody(body);
        this.setUser(user);
    }

    @Id
    private String id;
    private Instant date;
    private String title;

    private String body;

    private User user;

    private List<ComentarioDto> comentarios = new ArrayList<>();
}
