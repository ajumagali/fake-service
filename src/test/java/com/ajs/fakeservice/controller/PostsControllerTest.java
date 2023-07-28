package com.ajs.fakeservice.controller;

import com.ajs.fakeservice.model.Post;
import com.ajs.fakeservice.service.FakeApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PostsController.class)
class PostsControllerTest {
  @MockBean
  private FakeApiService fakeApiService;
  @Autowired
  private MockMvc mockMvc;

  @Test
  void testFindAllPostsSuccess() throws Exception {
    given(fakeApiService.findAllPosts()).willReturn(List.of(Post.builder().build()));
    mockMvc.perform(get("/posts"))
          .andExpect(status().is2xxSuccessful());
  }

  @Test
  void testFindPostByIdSuccess() throws Exception {
    given(fakeApiService.findPostById(1)).willReturn(Post.builder().build());
    mockMvc.perform(get("/posts/1"))
          .andExpect(status().is2xxSuccessful());
  }
}