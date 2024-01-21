package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.entities.PersonV1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }
}
