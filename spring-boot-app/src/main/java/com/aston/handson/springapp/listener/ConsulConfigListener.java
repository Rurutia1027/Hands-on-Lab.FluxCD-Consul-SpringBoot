package com.aston.handson.springapp.listener;

import com.aston.handson.springapp.props.MyConfigProperties;
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

    // @RefreshScope annotated bean
    private final MyConfigProperties myConfigProperties;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        log.info("⚡ Consul KV config updated, refreshing thread pool...");

        // Fetch remote Env diff local Env contents
        boolean featureAEnv = environment.getProperty("custom.config.featureA", Boolean.class, false);
        String featureBEnv = environment.getProperty("custom.config.featureB", "N/A");
        int maxItemsEnv = environment.getProperty("custom.config.maxItems", Integer.class, 0);
        String messageEnv = environment.getProperty("custom.config.message", "N/A");

        log.info(">>> Environment values: featureA={}, featureB={}, maxItems={}, message={}",
                featureAEnv, featureBEnv, maxItemsEnv, messageEnv);

        // Fetch remote updated configs
        log.info(">>> Bean values: featureA={}, featureB={}, maxItems={}, message={}",
                myConfigProperties.isFeatureA(),
                myConfigProperties.getFeatureB(),
                myConfigProperties.getMaxItems(),
                myConfigProperties.getMessage()
        );
    }
}