package com.ajs.fakeservice.controller;

import com.ajs.fakeservice.config.PublicHolidayApiClient;
import com.ajs.fakeservice.model.PublicHoliday;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/public-holidays")
public class PublicHolidayController {
  private final PublicHolidayApiClient publicHolidayApiClient;

  @GetMapping("/{year}/{countryCode}")
  @ResponseStatus(OK)
  public List<PublicHoliday> findPublicHolidaysByYearAndCountryCode(
        @PathVariable Integer year,
        @PathVariable String countryCode) {
    return publicHolidayApiClient.findPublicHolidaysByYearAndCountryCode(year, countryCode);
  }
}
