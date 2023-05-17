package com.rodrigo.GeekDev.services;

import com.rodrigo.GeekDev.domain.User;
import com.rodrigo.GeekDev.dtos.AtualizarUsuarioDto;
import com.rodrigo.GeekDev.dtos.InserirUsuarioDto;
import com.rodrigo.GeekDev.dtos.ListarPostsDto;
import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<ListarUsuarioDTO> findAll(Pageable paginacao){
        return userRepository.findAll(paginacao).map(ListarUsuarioDTO::new);
    }

    public ListarUsuarioDTO findById(String id){
        return new ListarUsuarioDTO(userRepository.findById(id).get());
    }

    public ListarUsuarioDTO create(InserirUsuarioDto usuarioDto){
        var user = userRepository.save(new User(usuarioDto));
        return new ListarUsuarioDTO(user);
    }

    public ListarUsuarioDTO update(AtualizarUsuarioDto usuarioDto){
        var oldUser = userRepository.findById(usuarioDto.id()).get();
        oldUser.setId(usuarioDto.id());
        oldUser.setName(usuarioDto.name());
        oldUser.setEmail(usuarioDto.email());
        var newUser = userRepository.save(oldUser);
        return new ListarUsuarioDTO(newUser);
    }

    public void remove(String id) {
        var oldUser = userRepository.findById(id).get();
        userRepository.delete(oldUser);
    }

    public List<ListarPostsDto> findPosts(String id) {
        var usuario = userRepository.findById(id).get();
        return usuario.getPosts().stream().map(ListarPostsDto::new).toList();
    }
}
