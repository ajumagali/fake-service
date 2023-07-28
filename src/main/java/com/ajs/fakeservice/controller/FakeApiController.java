package com.ajs.fakeservice.controller;

import com.ajs.fakeservice.model.Post;
import com.ajs.fakeservice.service.FakeApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class FakeApiController {
  private final FakeApiService fakeApiService;

  @GetMapping(value = "/posts")
  @ResponseStatus(HttpStatus.OK)
  public List<Post> findAllPosts() {
    log.info("Retrieve all posts");
    return fakeApiService.findAllPosts();
  }

}
