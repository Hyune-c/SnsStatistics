package com.albacheck.statistics.youtube.service;

import com.albacheck.statistics.config.YoutubeConfigure;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ChannelStatistics;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class YoutubeService {

  private final YoutubeConfigure configure;
  private final YouTube youtube;

  public YoutubeService(YoutubeConfigure configure) {
    this.configure = configure;
    this.youtube = configure.getYoutube();
  }

  public ChannelStatistics findStatistics() throws IOException {
    final String PART = "statistics";
    final String FIELDS = "items(statistics)";

    YouTube.Channels.List list = youtube.channels().list(PART);
    list.setKey(configure.getApiKey());
    list.setId(configure.getChannelId());
    list.setFields(FIELDS);

    ChannelListResponse channelListResponse = list.execute();
    List<Channel> channelList = channelListResponse.getItems();

    return channelList.get(0).getStatistics();
  }
}
