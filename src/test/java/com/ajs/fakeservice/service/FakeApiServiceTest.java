package com.ajs.fakeservice.service;

import com.ajs.fakeservice.config.FakeApiClient;
import com.ajs.fakeservice.model.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FakeApiServiceTest {
  @Mock
  private FakeApiClient fakeApiClient;
  @InjectMocks
  private FakeApiService fakeApiService;

  @Test
  void testFindAllPosts() {
    given(fakeApiClient.findAllPosts()).willReturn(List.of(Post.builder().build()));
    var res = fakeApiService.findAllPosts();

    assertAll("Validate list of posts", () -> {
      assertThat(res).isNotNull();
      assertThat(res.size()).isGreaterThan(0);
    });
  }

  @Test
  void testFindAllPostsFails() {
    given(fakeApiClient.findAllPosts()).willThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> fakeApiClient.findAllPosts());
  }

}