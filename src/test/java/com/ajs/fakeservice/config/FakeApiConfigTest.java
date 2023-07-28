package com.ajs.fakeservice.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ActiveProfiles("test")
class FakeApiConfigTest {
  @Autowired
  private FakeApiConfig fakeApiConfig;

  @Test
  void testConfigLoads() {
    assertThat(fakeApiConfig.getBaseUrl()).isEqualTo("https://jsonplaceholder.typicode.com/");
  }

}