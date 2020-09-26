package com.albacheck.statistics.instagram.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InstagramDto {

  int followedBy;
  int follow;

  public static InstagramDto of(int followedBy, int follow) {
    return InstagramDto.builder()
        .followedBy(followedBy)
        .follow(follow)
        .build();
  }
}
