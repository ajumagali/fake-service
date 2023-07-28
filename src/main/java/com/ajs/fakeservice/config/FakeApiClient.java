package com.ajs.fakeservice.config;

import com.ajs.fakeservice.model.Post;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface FakeApiClient {
  @GetExchange("/posts")
  List<Post> findAllPosts();
  @GetExchange("/posts/{id}")
  Post findPostById(@PathVariable("id") Integer id);
}
