package com.albacheck.statistics.youtube.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/youtube")
public class YoutubeController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public String updateStoreByExcel() {
    return "hello";
  }
}
