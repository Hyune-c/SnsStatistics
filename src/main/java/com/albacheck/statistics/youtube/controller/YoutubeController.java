package com.albacheck.statistics.youtube.controller;

import com.albacheck.statistics.youtube.service.YoutubeService;
import com.google.api.services.youtube.model.ChannelStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/statistics")
public class YoutubeController {

  private final YoutubeService youtubeService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/youtube")
  public ChannelStatistics findStatistics() {
    return youtubeService.findStatistics();
  }
}