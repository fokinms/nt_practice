package org.fokinms.nt.nt_first_practice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class PlugService {

    private final List<Integer> ids = new CopyOnWriteArrayList<>();


    public void addId(@NonNull Integer id) {
        ids.add(id);
    }

    public String getAllIds() {
        return ids.toString();
    }
}
