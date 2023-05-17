package com.rodrigo.GeekDev.resources;

import com.rodrigo.GeekDev.dtos.AtualizarUsuarioDto;
import com.rodrigo.GeekDev.dtos.InserirUsuarioDto;
import com.rodrigo.GeekDev.dtos.ListarPostsDto;
import com.rodrigo.GeekDev.dtos.ListarUsuarioDTO;
import com.rodrigo.GeekDev.services.PostService;
import com.rodrigo.GeekDev.services.UserService;
import com.rodrigo.GeekDev.utils.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<ListarPostsDto> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<ListarPostsDto>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        var param = Url.decoderUri(title);
        return ResponseEntity.ok().body(postService.findByTitle(param));
    }

}
