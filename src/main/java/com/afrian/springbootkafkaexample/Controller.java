package com.afrian.springbootkafkaexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping(path = "/send/foo/{str}")
    public void sendFoo(@PathVariable String str) throws JsonProcessingException {
        System.out.println("Sending to topic 1 with message : " + str);
        this.template.send("topic1", str);
        this.template.send("topic1", mapper.writeValueAsString(new Foo1(str)));
    }

    // topic not available
    @PostMapping(path = "/send/foo2/{str}")
    public void sendFoo2(@PathVariable String str) {
        System.out.println("Sending to topic 2 with message : " + str);
        this.template.send("topic2", str);
    }

}
