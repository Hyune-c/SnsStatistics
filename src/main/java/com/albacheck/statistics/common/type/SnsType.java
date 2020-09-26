package com.albacheck.statistics.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SnsType {

  YOUTUBE("YOUTUBE"),
  INSTAGRAM("INSTAGRAM");

  private final String key;
}
