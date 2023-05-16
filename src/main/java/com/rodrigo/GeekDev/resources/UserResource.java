package com.rodrigo.GeekDev.resources;

import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<Page<ListarUsuarioDTO>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(userService.findAll(paginacao));
    }
}
