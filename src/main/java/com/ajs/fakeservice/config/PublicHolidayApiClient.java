package com.ajs.fakeservice.config;

import com.ajs.fakeservice.model.PublicHoliday;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface PublicHolidayApiClient {
  @GetExchange("/{year}/{countryCode}")
  List<PublicHoliday> findPublicHolidaysByYearAndCountryCode(
        @PathVariable("year") Integer year,
        @PathVariable("countryCode") String countryCode);
}
