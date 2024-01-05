//package com.springbootkafkaexample.kafkademo.producer;
//
//import com.springbootkafkaexample.kafkademo.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JsonProducer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);
//
//    private KafkaTemplate<String, User> kafkaTemplate;
//
//    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage(User data){
//
//        LOGGER.info(String.format("Message sent %s", data.toString()));
//
//        Message<User> message = MessageBuilder
//                .withPayload(data)
//                .setHeader(KafkaHeaders.TOPIC, "topicOne")
//                .build();
//
//        kafkaTemplate.send(message);
//    }
//}
