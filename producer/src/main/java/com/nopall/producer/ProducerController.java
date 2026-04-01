package com.nopall.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producerService.sendMessage(message);
        return "Message u sent: " + message;
    }
    
}
