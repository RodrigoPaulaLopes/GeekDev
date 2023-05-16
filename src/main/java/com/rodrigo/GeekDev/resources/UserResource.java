package com.rodrigo.GeekDev.resources;

import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<ListarUsuarioDTO>> findAll() {

        List<ListarUsuarioDTO> users = new ArrayList<>();

        users.add(new ListarUsuarioDTO("1", "rodrigo", "rodrigo.lopes@email.com"));
        users.add(new ListarUsuarioDTO("2", "camille", "camille.lopes@email.com"));
        users.add(new ListarUsuarioDTO("3", "ana catarina", "ana.lopes@email.com"));
        users.add(new ListarUsuarioDTO("4", "ze da coxa", "ze.lopes@email.com"));

        return ResponseEntity.ok().body(users);
    }
}
