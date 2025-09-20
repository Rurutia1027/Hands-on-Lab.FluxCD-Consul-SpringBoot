package com.aston.handson.springapp.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RefreshScope
@RequiredArgsConstructor
public class ConsulConfigListener implements ApplicationListener<EnvironmentChangeEvent> {

    private final Environment environment;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        System.out.println("⚡ Consul KV config updated, refreshing thread pool...");

        try {
            boolean featureA = environment.getProperty("custom.config.featureA", Boolean.class, false);
            String featureB = environment.getProperty("custom.config.featureB", "N/A");
            int maxItems = environment.getProperty("custom.config.maxItems", Integer.class, 0);
            String message = environment.getProperty("custom.config.message", "N/A");

            log.info("custom.config.featureA=%s, custom.config.featureB=%s, custom.config.maxItems=%d, custom.config.message=%s%n",
                    featureA, featureB, maxItems, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}