package com.rodrigo.GeekDev.services;

import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<ListarUsuarioDTO> findAll(Pageable paginacao){
        return userRepository.findAll(paginacao).map(ListarUsuarioDTO::new);
    }
}
