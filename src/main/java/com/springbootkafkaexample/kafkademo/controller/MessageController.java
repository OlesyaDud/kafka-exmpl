package com.springbootkafkaexample.kafkademo.controller;

import com.springbootkafkaexample.kafkademo.producer.StringProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka-message")
public class MessageController {
    private StringProducer producer;

    public MessageController(StringProducer producer) {
        this.producer = producer;
    }

//    http:localhost:8080/api/v1/kafka-message/publish?message=hello
//    to retrieve the value from query param "message" use @RequestParam
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message is sent to the topic");
    }

}
