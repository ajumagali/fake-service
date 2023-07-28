package com.ajs.fakeservice.error;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Builder
@Data
public class CustomErrorResponse {
  private final HttpStatusCode status;
  private final String message;
  private final LocalDateTime timestamp;
}
