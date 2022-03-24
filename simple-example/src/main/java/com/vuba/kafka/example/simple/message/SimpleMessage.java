package com.vuba.kafka.example.simple.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleMessage {

    private String text;
    private Date timestamp;
    private String sender;
}
