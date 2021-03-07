package net.xonich.olorin.valinor.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public final class AddRecordListener {
    //todo configs!
    private final ExecutorService threads = Executors.newFixedThreadPool(1);

    public AddRecordListener(Consumer<String, String> kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    private final Consumer<String, String> kafkaConsumer;

    @PostConstruct
    public void init() {
        Runnable listenerLoop = () -> {
            kafkaConsumer.subscribe(List.of("olorin.append.records"));
            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.of(1000, ChronoUnit.MILLIS));
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    this.processRecord(consumerRecord);
                }
            }
        };
        threads.submit(listenerLoop);
    }

    public void processRecord(ConsumerRecord<String, String> consumerRecord) {
        System.out.println(consumerRecord);
    }
}
