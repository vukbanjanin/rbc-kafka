package com.vuba.kafka.example.simpleexample.producer;

import com.vuba.kafka.example.simpleexample.message.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePublisher {

    private final KafkaTemplate kafkaTemplate;
    private final RecordProducer recordProducer;

    @Value("${spring.kafka.topic.simple-message-topic}")
    private String KAFKA_TOPIC;

    public MessagePublisher(KafkaTemplate kafkaTemplate, RecordProducer recordProducer) {
        this.kafkaTemplate = kafkaTemplate;
        this.recordProducer = recordProducer;
    }

    public void sendMessage(SimpleMessage message) {
        var kafkaRecord = recordProducer.createKafkaRecord(KAFKA_TOPIC, message);
        kafkaTemplate.send(kafkaRecord);
        LOG.info("published message: [{}]", message);
    }
}
