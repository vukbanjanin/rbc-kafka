package com.vuba.kafka.example.simpleexample.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-producer")
public class ProducerController {

    public static final String PRODUCE_MESSAGE_URL = "/produce/number-of-messages/{numberOfMessages}";
    private final MessageService messageService;

    public ProducerController(MessagePublisher messagePublisher, MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = PRODUCE_MESSAGE_URL)
    public void produceMessage(@PathVariable("numberOfMessages") int numberOfMessages) {
        messageService.produceMessages(numberOfMessages);
    }
}
