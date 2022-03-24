package com.vuba.kafka.example.simpleexample.producer;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class MessageService {

    private final MessageFactory messageFactory;
    private final MessagePublisher messagePublisher;

    public MessageService(MessageFactory messageFactory, MessagePublisher messagePublisher) {
        this.messageFactory = messageFactory;
        this.messagePublisher = messagePublisher;
    }

    public void produceMessages(int numberOfMessage){
        IntStream.range(0,numberOfMessage)
                .mapToObj(messageFactory::generateSimpleMessage)
                .forEach(messagePublisher::sendMessage);
    }
}
