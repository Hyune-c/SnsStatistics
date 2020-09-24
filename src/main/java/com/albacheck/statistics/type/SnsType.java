package com.albacheck.statistics.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SnsType {

  YOUTUBE("YOUTUBE", "UCf9xSWkce6eYS4pu-hylrdQ");

  private final String key;
  private final String channelId;
}
