package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.entities.HelloWordBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWordController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-word-2")
    public String helloWord2(){
        return "Hello Word";
    }
    @GetMapping(path = "/hello-word")
    public String helloWord(){
        return "Hello Word";
    }
    @GetMapping(path = "/hello-word-bean")
    public HelloWordBean helloWordBean(){
        return new HelloWordBean("Hello word");
    }

    @GetMapping(path = "/hello-word/path-variable/{name}")
    public HelloWordBean helloWordPathVariable(@PathVariable String name){
        return new HelloWordBean(String.format("Hello word %s"+name));
    }

}
