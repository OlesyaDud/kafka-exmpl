package com.springbootkafkaexample.kafkademo.consumer;

import com.springbootkafkaexample.kafkademo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

//    consumer instances
    @KafkaListener(topics = "new-topic2", groupId = "groupId1")
    public void consume1(String message){
        log.info(String.format("Consumer1 received %s", message));
    }

    @KafkaListener(topics = "new-topic4", groupId = "groupId")
    public void consumeUser(User user){
        log.info("Consumer1 received %s", user.toString());
    }

}
