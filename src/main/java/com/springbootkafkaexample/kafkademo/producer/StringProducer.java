package com.springbootkafkaexample.kafkademo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public StringProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("topicOne", message);
    }
}
