package com.vuba.kafka.example.simple.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuba.kafka.example.simple.message.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private final ObjectMapper objectMapper;

    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${spring.kafka.topic.simple-message-topic}",
            containerFactory = "simpleMessageKafkaListenerContainerFactory")
    public synchronized void listen(SimpleMessage simpleMessage){
        LOG.info("[KAFKA-CONSUMER] received message");
        LOG.info("[KAFKA-CONSUMER] contents of message: [{}]", simpleMessage);
    }
}
