package com.rodrigo.GeekDev.repository;

import com.rodrigo.GeekDev.domain.Post;
import com.rodrigo.GeekDev.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String title);
}
