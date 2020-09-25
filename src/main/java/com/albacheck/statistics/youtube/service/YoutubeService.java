package com.albacheck.statistics.youtube.service;

import static com.albacheck.statistics.config.StatisticsConfigure.HTTP_TRANSPORT;
import static com.albacheck.statistics.config.StatisticsConfigure.JSON_FACTORY;
import static com.albacheck.statistics.type.SnsType.YOUTUBE;

import com.albacheck.statistics.config.YoutubeConfigure;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ChannelStatistics;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YoutubeService {

  private final YoutubeConfigure youtubeConfigure;

  public ChannelStatistics findStatistics() throws IOException {
    YouTube youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, request -> {
    }).setApplicationName("albacheck-youtube-statistics").build();
    String apiKey = youtubeConfigure.getApiKey();

    YouTube.Channels.List list = youtube.channels().list("statistics");
    list.setKey(apiKey);
    list.setId(YOUTUBE.getChannelId());
    list.setFields("items(statistics)");

    ChannelListResponse channelListResponse = list.execute();
    List<Channel> channelList = channelListResponse.getItems();

    return channelList.get(0).getStatistics();
  }
}
