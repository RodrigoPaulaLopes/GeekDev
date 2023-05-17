package com.rodrigo.GeekDev.services;

import com.rodrigo.GeekDev.domain.User;
import com.rodrigo.GeekDev.dtos.AtualizarUsuarioDto;
import com.rodrigo.GeekDev.dtos.InserirUsuarioDto;
import com.rodrigo.GeekDev.dtos.ListarPostsDto;
import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.repository.PostRepository;
import com.rodrigo.GeekDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public ListarPostsDto findById(String id){
        return new ListarPostsDto(postRepository.findById(id).get());
    }

    public List<ListarPostsDto> findByTitle(String title){
        return postRepository.findByTitleContainingIgnoreCase(title).stream().map(ListarPostsDto::new).toList();
    }



}
