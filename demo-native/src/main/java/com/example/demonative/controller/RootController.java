package com.example.demonative.controller;

import com.example.demonative.service.MessageService;
import com.example.demonative.pojo.Message;
import com.example.demonative.pojo.Stuff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RootController {

    private final MessageService messageService;

    private final RestTemplate restTemplate;

    public RootController(MessageService messageService, RestTemplate restTemplate) {
        this.messageService = messageService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public Message message() {
        // pristup pres reflexi
        Stuff stuff = restTemplate.getForObject("http://localhost:8080/stuff", Stuff.class);
        // pristup pres proxy
        Message message = messageService.getMessage("data from proxy + " + stuff.getStuff());
        return message;
    }

}
