package com.rodrigo.GeekDev.resources;

import com.rodrigo.GeekDev.dtos.AtualizarUsuarioDto;
import com.rodrigo.GeekDev.dtos.InserirUsuarioDto;
import com.rodrigo.GeekDev.dtos.ListarPostsDto;
import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @GetMapping("/{id}")
    public ResponseEntity<ListarUsuarioDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<ListarPostsDto>> findPosts(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findPosts(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ListarUsuarioDTO> create(@RequestBody InserirUsuarioDto usuarioDto, UriComponentsBuilder builder){
        var user = userService.create(usuarioDto);
        var uri = builder.path("/users/{id}").buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ListarUsuarioDTO> create(@RequestBody AtualizarUsuarioDto usuarioDto){
        var user = userService.update(usuarioDto);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
