package com.ajs.fakeservice.config;

import com.ajs.fakeservice.model.Post;
import java.util.List;
import org.springframework.web.service.annotation.GetExchange;

public interface FakeApiClient {
  @GetExchange("/posts")
  List<Post> findAllPosts();
}
