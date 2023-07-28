package com.ajs.fakeservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "publicholidayapi")
@Data
public class PublicHolidayApiConfig {
  private String baseUrl;
}
