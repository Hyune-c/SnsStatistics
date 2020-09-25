package com.albacheck.statistics.config;

import static com.albacheck.statistics.config.CommonConfigure.HTTP_TRANSPORT;
import static com.albacheck.statistics.config.CommonConfigure.JSON_FACTORY;

import com.google.api.services.youtube.YouTube;
import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "youtube")
public class YoutubeConfigure {

  private String apiKey;
  private String channelId;
  private YouTube youtube;

  @PostConstruct
  public void postConstruct() {
    this.youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, request -> {
    }).setApplicationName("albacheck-youtube-statistics").build();
  }
}
