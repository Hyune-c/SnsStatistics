package com.albacheck.statistics.instagram.service;

import com.albacheck.statistics.instagram.dto.InstagramDto;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstagramService {

  public InstagramDto findStatistics() {

    RestTemplate restTemplate = new RestTemplate();

    String json = restTemplate.getForObject("https://www.instagram.com/albacheck/?__a=1", String.class);

    Integer followed = JsonPath.parse(json).read("$.graphql.user.edge_followed_by.count");
    Integer follow = JsonPath.parse(json).read("$.graphql.user.edge_follow.count");

    return InstagramDto.of(followed, follow);
  }
}
