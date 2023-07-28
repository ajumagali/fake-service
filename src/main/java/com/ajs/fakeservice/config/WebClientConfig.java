package com.ajs.fakeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

  @Bean
  public PublicHolidayApiClient publicHolidayApiWebClient(final PublicHolidayApiConfig config) {
    return HttpServiceProxyFactory
          .builder(WebClientAdapter.forClient(WebClient.builder()
                .baseUrl(config.getBaseUrl())
                .build()))
          .build().createClient(PublicHolidayApiClient.class);
  }

  @Bean
  public FakeApiClient fakeApiWebClient(final FakeApiConfig fakeApiConfig) {
    return HttpServiceProxyFactory
          .builder(WebClientAdapter.forClient(WebClient.builder()
                .baseUrl(fakeApiConfig.getBaseUrl())
                .defaultHeaders(headers -> headers.setContentType(MediaType.APPLICATION_JSON))
                .build()))
          .build().createClient(FakeApiClient.class);
  }
}
