package com.vuba.kafka.example.simple.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuba.kafka.example.simple.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Value("${spring.kafka.topic.simple-message-topic}")
    private String KAFKA_TOPIC;

    @Qualifier("simpleMessageKafkaTemplate")
    private final KafkaTemplate kafkaTemplate;

    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(SimpleMessage message) {
        kafkaTemplate.send(KAFKA_TOPIC, message);
    }
}
