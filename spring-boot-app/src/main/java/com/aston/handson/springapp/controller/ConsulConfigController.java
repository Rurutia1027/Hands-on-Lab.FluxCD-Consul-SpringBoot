package com.aston.handson.springapp.controller;

import com.aston.handson.springapp.props.MyConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsulConfigController {

    private final MyConfigProperties config;

    @GetMapping("/app-custom-config")
    public String getConfig() {
        return String.format(
                "featureA=%s, featureB=%s, maxItems=%d, message=%s",
                config.isFeatureA(), config.getFeatureB(), config.getMaxItems(), config.getMessage()
        );
    }
}
