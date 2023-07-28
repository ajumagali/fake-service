package com.ajs.fakeservice.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(BAD_REQUEST)
  public CustomErrorResponse handleError(final MethodArgumentTypeMismatchException ex) {
    log.error("Request failed for", ex);
    return CustomErrorResponse.builder()
          .status(BAD_REQUEST)
          .message(ex.getMessage())
          .timestamp(LocalDateTime.now())
          .build();
  }
}
