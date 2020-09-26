package com.albacheck.statistics.summary.dto;

import com.albacheck.statistics.instagram.dto.InstagramDto;
import com.google.api.services.youtube.model.ChannelStatistics;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FindStatisticsRes {

  private ChannelStatistics youtube;
  private InstagramDto instagram;

  public static FindStatisticsRes of(ChannelStatistics youtube, InstagramDto instagram) {
    return FindStatisticsRes.builder()
        .youtube(youtube)
        .instagram(instagram)
        .build();
  }
}
