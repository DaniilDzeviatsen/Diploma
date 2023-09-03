package com.example.diploma.model.security;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "diploma.access-token")
@Value
public class AccessTokenProperties {
    String secret;
    Duration timeToLive;
}
