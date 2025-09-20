package com.aston.handson.springapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulConfigController {
    @Value("${custom.config.featureA}")
    private boolean featureA;

    @Value("${custom.config.featureB}")
    private String featureB;

    @Value("${custom.config.maxItems}")
    private int maxItems;

    @Value("${custom.config.message}")
    private String message;

    @GetMapping("/app-custom-config")
    public String getConfig() {
        return String.format(
                "featureA=%s, featureB=%s, maxItems=%d, message=%s",
                featureA, featureB, maxItems, message
        );
    }
}
