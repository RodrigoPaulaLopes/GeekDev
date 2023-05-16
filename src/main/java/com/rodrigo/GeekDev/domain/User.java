package com.rodrigo.GeekDev.domain;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    public static final Long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
}
