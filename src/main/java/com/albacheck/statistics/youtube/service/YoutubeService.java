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

  private final String API_KEY;
  private final String CHANNEL_ID;

  private final YouTube youtube;

  public YoutubeService(YoutubeConfigure configure) {
    this.youtube = configure.getYoutube();
    API_KEY = configure.getApiKey();
    CHANNEL_ID = configure.getChannelId();
  }

  public ChannelStatistics findStatistics() throws IOException {
    final String PART = "statistics";
    final String FIELDS = "items(statistics)";

    YouTube.Channels.List list = youtube.channels().list(PART);
    list.setKey(API_KEY);
    list.setId(CHANNEL_ID);
    list.setFields(FIELDS);

    ChannelListResponse channelListResponse = list.execute();
    List<Channel> channelList = channelListResponse.getItems();

    return channelList.get(0).getStatistics();
  }
}
