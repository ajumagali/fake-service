package com.ajs.fakeservice.service;

import com.ajs.fakeservice.config.FakeApiClient;
import com.ajs.fakeservice.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class FakeApiService {
  private final FakeApiClient fakeApiClient;

  public List<Post> findAllPosts() {
    log.info("Call fake-api service to find all posts");
    return fakeApiClient.findAllPosts();
  }
}
