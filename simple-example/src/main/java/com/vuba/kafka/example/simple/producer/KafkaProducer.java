package com.vuba.kafka.example.simple.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuba.kafka.example.simple.message.SimpleMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Value("${spring.kafka.topic.simple-message-topic}")
    private String KAFKA_TOPIC;

    private final KafkaTemplate kafkaTemplate;

    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(SimpleMessage message) {
        var kafkaRecord = createKafkaRecord(message);
        kafkaTemplate.send(kafkaRecord);
    }

    private ProducerRecord createKafkaRecord(SimpleMessage simpleMessage){
        var serialisedMessage = serialiseMessage(simpleMessage);
        var producerRecord = new ProducerRecord<>(KAFKA_TOPIC, simpleMessage.getSender(), serialisedMessage);
        return producerRecord;
    }

    private String serialiseMessage(SimpleMessage message){
        try {
            return OBJECT_MAPPER.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
