package com.vuba.kafka.example.consumer.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

@Component
public class MessageDeserializer {

    private final ObjectMapper objectMapper;

    public MessageDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SimpleMessage deserializeSimpleMessage(ConsumerRecord<String, String> consumerRecord) {
        try {
            return objectMapper.readValue(consumerRecord.value(), SimpleMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new SimpleMessage();
    }
}
