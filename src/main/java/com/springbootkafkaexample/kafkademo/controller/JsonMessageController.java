//package com.springbootkafkaexample.kafkademo.controller;
//
//import com.springbootkafkaexample.kafkademo.model.User;
//import com.springbootkafkaexample.kafkademo.producer.JsonProducer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/kafka")
//public class JsonMessageController {
//
//    private JsonProducer jsonProducer;
//
//    public JsonMessageController(JsonProducer jsonProducer) {
//        this.jsonProducer = jsonProducer;
//    }
//
//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestBody User user){
//        jsonProducer.sendMessage(user);
//        return ResponseEntity.ok("Json message sent to kafka topic");
//    }
//}
