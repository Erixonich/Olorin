package net.xonich.olorin.mithlond.controller;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mithlond")
public class TempController {
    @Autowired
    Producer<String, String> producer;

    @PostMapping("/test")
    public String ping(@RequestBody String body) {
        producer.send(new ProducerRecord<>("valinor", "foo"));
        return "Success!";
    }
}
