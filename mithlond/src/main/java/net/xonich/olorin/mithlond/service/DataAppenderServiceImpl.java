package net.xonich.olorin.mithlond.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DataAppenderServiceImpl implements DataAppenderService {
    private final Producer<String, String> kafka;

    public DataAppenderServiceImpl(Producer<String, String> kafka) {
        this.kafka = kafka;
    }

    @Override
    public void appendRecord(String record) {
        kafka.send(new ProducerRecord<>("olorin.append.records", UUID.randomUUID().toString(), record));
    }
}
