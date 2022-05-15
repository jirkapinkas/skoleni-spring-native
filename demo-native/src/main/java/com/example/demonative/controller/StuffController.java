package com.example.demonative.controller;

import com.example.demonative.pojo.Stuff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuffController {

    @GetMapping("/stuff")
    public Stuff stuff() {
        return new Stuff("stuff");
    }

}
