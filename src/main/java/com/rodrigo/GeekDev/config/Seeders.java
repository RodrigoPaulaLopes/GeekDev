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

        User maria = new User( "Maria Brown", "maria@gmail.com");
        User alex = new User("Alex Green", "alex@gmail.com");
        User bob = new User("Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post mariaPost = new Post(null, Instant.now(), "Viajar", "Viajem para são paulo", maria);
        Post mariaPost2 = new Post(null, Instant.now(), "Dormir", "Bateu o sono pessoal fui", maria);
        Post mariaPost3 = new Post(null, Instant.now(), "Como fazer coxinha", "como fazer coxinha pessoal", maria);
        Post alexPost = new Post(null, Instant.now(), "jogoando futeboll", "Jogando futebol com os parças", alex);
        Post bobPost = new Post(null, Instant.now(), "jogoando Video game", "Jogando video game com os parças", bob);

        postRepository.saveAll(Arrays.asList(mariaPost, mariaPost2, mariaPost3, alexPost, bobPost));

        maria.getPosts().addAll(Arrays.asList(mariaPost, mariaPost2, mariaPost3));
        alex.getPosts().add(alexPost);
        bob.getPosts().add(bobPost);
        userRepository.saveAll(Arrays.asList(maria, alex, bob));



    }
}
