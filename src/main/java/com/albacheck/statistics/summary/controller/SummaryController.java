package com.albacheck.statistics.summary.controller;

import com.albacheck.statistics.instagram.service.InstagramService;
import com.albacheck.statistics.summary.dto.FindStatisticsRes;
import com.albacheck.statistics.youtube.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/statistics")
public class SummaryController {

  private final YoutubeService youtubeService;
  private final InstagramService instagramService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public FindStatisticsRes findStatistics() {
    return FindStatisticsRes.of(youtubeService.findStatistics(), instagramService.findStatistics());
  }
}