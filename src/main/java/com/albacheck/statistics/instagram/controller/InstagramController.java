package com.albacheck.statistics.instagram.controller;

import com.albacheck.statistics.instagram.dto.InstagramDto;
import com.albacheck.statistics.instagram.service.InstagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/statistics")
public class InstagramController {

  private final InstagramService instagramService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/instagram")
  public InstagramDto findInstagramStatistics() {
    return instagramService.findStatistics();
  }
}