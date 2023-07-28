package com.ajs.fakeservice.service;

import com.ajs.fakeservice.config.EmailReceiverConfig;
import com.ajs.fakeservice.config.PublicHolidayApiClient;
import com.ajs.fakeservice.model.PublicHoliday;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PublicHolidayService {
  public static final String GB = "GB";
  public static final String YYYY_MM_DD = "yyyy-MM-dd";
  private final PublicHolidayApiClient publicHolidayApiClient;
  private final EmailService emailService;
  private final EmailReceiverConfig emailReceiverConfig;

//  @Scheduled(cron = "00 25 18 ? * *")
  @Scheduled(fixedRate = 10000)
  public void checkPublicHolidayForToday() {
    log.info("Checking public holiday for {}", LocalDate.now());
    List<PublicHoliday> publicHolidays = publicHolidayApiClient.findPublicHolidaysByYearAndCountryCode(
          LocalDate.now().getYear(), GB);

    for (PublicHoliday publicHoliday : publicHolidays) {
      if (publicHoliday.getDate() != null) {
        LocalDate date = LocalDate.parse(publicHoliday.getDate(), DateTimeFormatter.ofPattern(YYYY_MM_DD));
//        if (date.equals(LocalDate.now())) {
        if (date.equals(LocalDate.of(2023, 01, 01))) {
          log.info("Today is a bank holiday {}", publicHoliday.getName());
          final String msg = """
                Hey,
                      
                Today is %s!
                Enjoy it!
                      
                Cheers,
                Your Public Holiday Service
                """;
          emailService.sendEmail(emailReceiverConfig.getEmailTo(),
                "Happy " + publicHoliday.getName(),
                String.format(msg, publicHoliday.getName())
          );
        }
      }
    }
  }
}
