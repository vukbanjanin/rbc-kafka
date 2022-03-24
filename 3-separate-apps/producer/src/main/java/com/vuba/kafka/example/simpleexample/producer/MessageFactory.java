package com.vuba.kafka.example.simpleexample.producer;

import com.vuba.kafka.example.simpleexample.message.SimpleMessage;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageFactory {

    public SimpleMessage generateSimpleMessage(int counter){
        String sender = "producer";
        String text = "message-"+counter;
        Date currentDate = new Date();
        String id = sender+"."+currentDate.toInstant();
        return SimpleMessage
                .builder()
                .id(id)
                .sender(sender)
                .timestamp(currentDate)
                .text(text)
                .build();
    }
}
