package com.rodrigo.GeekDev.domain;

import com.rodrigo.GeekDev.dtos.InserirUsuarioDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "user")
public class User implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    public User(InserirUsuarioDto usuarioDto) {
        this.setName(usuarioDto.name());
        this.setEmail(usuarioDto.email());
    }


}
