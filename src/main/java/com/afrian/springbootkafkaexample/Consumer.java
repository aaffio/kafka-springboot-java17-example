package com.afrian.springbootkafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "topic1", groupId = "my-group")
    public void receiveMessageTopic1(String message) {
        System.out.println("Received message: " + message);
    }
}
