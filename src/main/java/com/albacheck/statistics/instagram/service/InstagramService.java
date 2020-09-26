package com.albacheck.statistics.instagram.service;

import com.albacheck.statistics.config.InstagramConfigure;
import com.albacheck.statistics.instagram.dto.InstagramDto;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class InstagramService {

  private final String BASE_URL;
  private final RestTemplate restTemplate;

  public InstagramService(InstagramConfigure configure) {
    BASE_URL = configure.getBaseUrl();
    restTemplate = new RestTemplate();
  }

  public InstagramDto findStatistics() {
    String restUrl = "/albacheck/?__a=1";
    String json = restTemplate.getForObject(BASE_URL + restUrl, String.class);

    log.info("##### ++ info json: {}", json);
    log.debug("##### ++ debuf json: {}", json);
    Integer followed = JsonPath.parse(json).read("$.graphql.user.edge_followed_by.count");
    Integer follow = JsonPath.parse(json).read("$.graphql.user.edge_follow.count");

    return InstagramDto.of(followed, follow);
  }
}
