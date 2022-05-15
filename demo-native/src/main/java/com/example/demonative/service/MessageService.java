package com.example.demonative.service;

import com.example.demonative.pojo.Message;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Cacheable("message")
    public Message getMessage(String message) {
        return new Message(message);
    }

}
