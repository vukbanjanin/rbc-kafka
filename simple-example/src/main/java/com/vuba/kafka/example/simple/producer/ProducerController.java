package com.vuba.kafka.example.simple.producer;

import com.vuba.kafka.example.simple.message.SimpleMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/kafka-producer")
public class ProducerController {

    public static final String PRODUCE_MESSAGE_URL = "/produce/sender/{sender}/text/{text}";
    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = PRODUCE_MESSAGE_URL)
    public void produceMessage(@PathVariable("sender")String sender,
                                 @PathVariable("text")String text){
        var simpleMessage = SimpleMessage
                .builder()
                .sender(sender)
                .text(text)
                .timestamp(new Date())
                .build();
        kafkaProducer.sendMessage(simpleMessage);
    }
}
