package com.vuba.kafka.example.examplewithcommit.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vuba.kafka.example.examplewithcommit.message.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private final ObjectMapper objectMapper;

    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${spring.kafka.topic.simple-message-topic}")
    public synchronized void listen(ConsumerRecord<String, String> record,
                                    Acknowledgment acknowledgment) {
        LOG.info("[KAFKA-CONSUMER] received message");
        var simpleMessage = deserializeSimpleMessage(record);
        LOG.info("[KAFKA-CONSUMER] contents of message: [{}]", simpleMessage);
        //TODO: uncomment this to see the loop start
//        causeNPE();
        acknowledgment.acknowledge();
        LOG.info("[KAFKA-CONSUMER] acknowledged message");
    }

    private SimpleMessage deserializeSimpleMessage(ConsumerRecord<String, String> consumerRecord) {
        try {
            return objectMapper.readValue(consumerRecord.value(), SimpleMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new SimpleMessage();
    }

    private void causeNPE() {
        SimpleMessage message = null;
        LOG.info("Sender: {}", message.getSender());
    }
}
