package com.vuba.kafka.example.examplewithcommit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/")
public class IndexController {

    @ApiIgnore("Redirect index to Swagger UI")
    @GetMapping
    public ResponseEntity<byte[]> redirect(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","swagger-ui/");
        return new ResponseEntity<>(null, headers, HttpStatus.FOUND);
    }
}
