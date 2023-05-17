package com.rodrigo.GeekDev.config;

import com.rodrigo.GeekDev.domain.Post;
import com.rodrigo.GeekDev.domain.User;
import com.rodrigo.GeekDev.repository.PostRepository;
import com.rodrigo.GeekDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Seeders implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post mariaPost = new Post(null, Instant.now(), "Viajar", "Viajem para são paulo", maria);
        Post alexPost = new Post(null, Instant.now(), "jogoando futeboll", "Jogando futebol com os parças", alex);

        postRepository.saveAll(Arrays.asList(mariaPost, alexPost));



    }
}
