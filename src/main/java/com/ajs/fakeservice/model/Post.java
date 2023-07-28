package com.ajs.fakeservice.model;

import lombok.Builder;

@Builder
public record Post(Integer userId, Integer id, String title, String body) { }