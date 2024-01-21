package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.DAO.UserDaoServices;
import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    UserDaoServices services;

    public UserResource(UserDaoServices services) {
        this.services = services;
    }

    //
    @GetMapping("/users")
    public List<User> retrieveAll(){
        return services.listAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return services.findOne(id);
    }
   //@POST /users

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        services.save(user);


       return ResponseEntity.created(null).build();
    }

}
