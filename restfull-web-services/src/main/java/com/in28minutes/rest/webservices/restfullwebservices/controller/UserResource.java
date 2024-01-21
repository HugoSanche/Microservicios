package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.DAO.UserDaoServices;
import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user =services.findOne(id);

        //if services return null throw error
        if(user==null)
            throw new UserNotFoundException("id;"+id);
        return services.findOne(id);
    }
   //@POST /users

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser= services.save(user);

       //With the next code you can create a URI to see in postman the location of the new user created.
        //
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
       return ResponseEntity.created(location).build();
    }
    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable Integer id){
        services.deleteById(id);
    }

}
