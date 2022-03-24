package com.vuba.kafka.example.simpleexample.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuba.kafka.example.simpleexample.message.SimpleMessage;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

@Component
public class RecordProducer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public ProducerRecord createKafkaRecord(String topic, SimpleMessage simpleMessage) {
        var serialisedMessage = serialiseMessage(simpleMessage);
        var producerRecord = new ProducerRecord<>(topic, simpleMessage.getId(), serialisedMessage);
        return producerRecord;
    }

    private String serialiseMessage(SimpleMessage message) {
        try {
            return OBJECT_MAPPER.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
