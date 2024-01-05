package com.springbootkafkaexample.kafkademo.controller;

import com.springbootkafkaexample.kafkademo.model.User;
import com.springbootkafkaexample.kafkademo.producer.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer-app")
public class EventController {

    @Autowired
    private MessagePublisher messagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            messagePublisher.sendNewMessageToTopic(message);
            return ResponseEntity.ok("Message published");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish/user")
    public ResponseEntity<?> publishUser(@RequestBody User user){
        try {
            messagePublisher.sendUserToTopic(user);
            return ResponseEntity.ok("User published");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
