package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.DAO.PostRepository;
import com.in28minutes.rest.webservices.restfullwebservices.DAO.UserRepository;
import com.in28minutes.rest.webservices.restfullwebservices.entities.Post;
import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    UserRepository userRepository;
    PostRepository postRepository;


    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //
    @GetMapping("/jpa/users")
    public List<User> retrieveAll(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional <User> user =userRepository.findById(id);

        //if services return null throw error
        if(user.isEmpty())
            throw new UserNotFoundException("id;"+id);

        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAll());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
   //@POST /users

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User savedUser= userRepository.save(user);

       //With the next code you can create a URI to see in postman the location of the new user created.
        //
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable Integer id){
        userRepository.deleteById(id);
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        //if services return null throw error
        if (user.isEmpty())
            throw new UserNotFoundException("id;" + id);
        return user.get().getPosts();
    }


    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> CreatePostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        //if services return null throw error
        if (user.isEmpty())
            throw new UserNotFoundException("id;" + id);

        post.setUser(user.get());
        Post savePost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
