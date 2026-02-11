package org.fokinms.nt.nt_first_practice.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.fokinms.nt.nt_first_practice.service.PlugService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PlugController {

    private final PlugService plugService;

    @PostMapping("/plug/{id}")
    public void addId(@NonNull @PathVariable Integer id) {
        plugService.addId(id);
    }

    @GetMapping("/plug/getIds")
    public String getAllIds() {
        return plugService.getAllIds();
    }
}
