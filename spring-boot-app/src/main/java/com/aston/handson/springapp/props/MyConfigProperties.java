package com.aston.handson.springapp.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@RefreshScope
@Component
@ConfigurationProperties(prefix = "custom.config")
@Data
public class MyConfigProperties {
    private boolean featureA;
    private String featureB;
    private int maxItems;
    private String message;
}