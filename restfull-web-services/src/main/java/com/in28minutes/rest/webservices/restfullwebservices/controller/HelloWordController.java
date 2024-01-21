package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.entities.HelloWordBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWordController {

    private MessageSource mesaggeSource;

    public HelloWordController(MessageSource mesaggeSource) {
        this.mesaggeSource = mesaggeSource;
    }

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
    @GetMapping(path = "/hello-word-Internationalized")
    public String helloWordInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return mesaggeSource.getMessage("good.morning.message",null,"Default Message",locale);
       // return "Hello Word v2";
    }

    //1:
    //2:
   // -Example: 'en' - English (Good Morning)
    // -Example: 'nl' - Dutch (Goedemorgen)
    // -Example: 'fr' - French (Bonjour)
    // -Example: 'es' - Español (Buenos dias)
}
