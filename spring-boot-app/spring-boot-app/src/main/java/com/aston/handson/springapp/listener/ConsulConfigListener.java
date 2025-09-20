package com.aston.handson.springapp.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsulConfigListener implements ApplicationListener<EnvironmentChangeEvent> {

    private final Environment environment;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        System.out.println("⚡ Consul KV config updated, refreshing thread pool...");

        try {
            boolean featureA = environment.getProperty("demo.featureA", Boolean.class, false);
            String featureB = environment.getProperty("demo.featureB", "N/A");
            int maxItems = environment.getProperty("demo.maxItems", Integer.class, 0);
            String message = environment.getProperty("demo.message", "N/A");

            System.out.printf(
                    "demo.featureA=%s, demo.featureB=%s, demo.maxItems=%d, demo.message=%s%n",
                    featureA, featureB, maxItems, message
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}