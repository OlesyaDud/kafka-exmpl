package com.springbootkafkaexample.kafkademo.producer;

import com.springbootkafkaexample.kafkademo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("other-topic", message);
        future.whenComplete((result, ex)-> {
//            if there is not excaption
            if (ex == null){
                System.out.println(message + result.getRecordMetadata().offset());
            }else{
                System.out.println("Unable to send a message %s" + ex.getMessage());
            }
        });
    }

    public void sendNewMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("new-topic2", message);
        future.whenComplete((result, ex)-> {
            if (ex == null){
                System.out.println(message + " with offset " + result.getRecordMetadata().offset());
            }else{
                System.out.println("Unable to send a message %s" + ex.getMessage());
            }
        });
    }

    public void sendUserToTopic(User user){
        try{
        CompletableFuture<SendResult<String, Object>> future = template.send("new-topic4", user);
        future.whenComplete((result, ex)-> {
            if (ex == null){
                System.out.println(user + " with offset " + result.getRecordMetadata().offset());
            }else{
                System.out.println("Unable to send a message %s" + ex.getMessage());
            }
        });
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
