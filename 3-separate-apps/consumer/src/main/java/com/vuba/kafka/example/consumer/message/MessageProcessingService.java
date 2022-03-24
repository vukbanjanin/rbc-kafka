package com.vuba.kafka.example.consumer.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageProcessingService {

    public void processMessage(SimpleMessage simpleMessage){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("processed message [message={}]", simpleMessage);
    }
}
