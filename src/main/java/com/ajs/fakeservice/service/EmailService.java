package com.ajs.fakeservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
  private final JavaMailSender mailSender;

  @Async
  public void sendEmail(final String toEmail, final String subject, final String message) {
    log.info("Notifying of public holiday to {}", toEmail);
    final SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(toEmail);
    mailMessage.setSubject(subject);
    mailMessage.setText(message);
    mailSender.send(mailMessage);
  }
}
