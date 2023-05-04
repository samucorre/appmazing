package com.campusdual.appmazing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contacts controller works, "+ name +"!";
    }
}
