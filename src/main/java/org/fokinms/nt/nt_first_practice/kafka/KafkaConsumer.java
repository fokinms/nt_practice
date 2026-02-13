package org.fokinms.nt.nt_first_practice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topics.jmeter[0]}", groupId = "${kafka.group-id}")
    public void receiveMessage(String message) {
        log.info("received message: {}", message);
    }
}
