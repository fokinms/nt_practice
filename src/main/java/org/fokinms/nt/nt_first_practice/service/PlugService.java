package org.fokinms.nt.nt_first_practice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fokinms.nt.nt_first_practice.kafka.KafkaProducer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlugService {

    private final List<Integer> ids = new CopyOnWriteArrayList<>();
    private final KafkaProducer kafkaProducer;
    private static final int batchSize = 100;

    public void addId(@NonNull Integer id) {
        handleCache();
        ids.add(id);
        log.info("id {} saved in cache", id);
    }

    public String getAllIds() {
        log.info("returned current cache");
        return ids.toString();
    }

    private void handleCache() {
        if (achievedBatchSize()) {
            sendBatchToKafka(ids);
            ids.clear();
        }
    }

    private boolean achievedBatchSize() {
        return ids.size() == batchSize;
    }

    private void sendBatchToKafka(List<Integer> batch) {
        kafkaProducer.sendBatchSync(batch);
    }
}
