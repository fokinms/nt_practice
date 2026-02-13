package org.fokinms.nt.nt_first_practice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topics.jmeter[0]}")
    private String topic;

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
        log.info("a message with the text \"{}\" was sent", message);
    }

    public void sendBatchSync(List<Integer> messages) {
        messages.forEach(m -> sendMessage(String.valueOf(m)));
    }
}
