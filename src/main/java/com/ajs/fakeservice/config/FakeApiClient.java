package com.ajs.fakeservice.config;

import com.ajs.fakeservice.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public interface FakeApiClient {
  @GetMapping("/posts")
  Mono<Post> findAllPosts();
}
