package com.ajs.fakeservice.controller;

import com.ajs.fakeservice.model.Post;
import com.ajs.fakeservice.service.FakeApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@Slf4j
public class FakeApiController {
  private final FakeApiService fakeApiService;

  @GetMapping(value = "/posts")
  @ResponseStatus(OK)
  public List<Post> findAllPosts() {
    log.info("Retrieve all posts");
    return fakeApiService.findAllPosts();
  }

  @GetMapping(value = "/posts/{id}")
  @ResponseStatus(OK)
  public Post findPostById(@PathVariable Integer id) {
    log.info("Retrieve post by id {}", id);
    return fakeApiService.findPostById(id);
  }
}
