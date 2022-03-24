package com.vuba.kafka.example.consumer.consumer;

import com.vuba.kafka.example.consumer.message.MessageDeserializer;
import com.vuba.kafka.example.consumer.message.MessageProcessingService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final MessageDeserializer messageDeserializer;
    private final MessageProcessingService messageProcessingService;

    public KafkaConsumer(MessageDeserializer messageDeserializer, MessageProcessingService messageProcessingService) {
        this.messageDeserializer = messageDeserializer;
        this.messageProcessingService = messageProcessingService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.simple-message-topic}")
    public synchronized void listen(ConsumerRecord<String, String> record,
                                    Acknowledgment acknowledgment) {

        var simpleMessage = messageDeserializer.deserializeSimpleMessage(record);
        messageProcessingService.processMessage(simpleMessage);
        acknowledgment.acknowledge();
    }
}
