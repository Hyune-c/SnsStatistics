package com.albacheck.statistics.config;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class StatisticsConfigure {

  public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  public static final JsonFactory JSON_FACTORY = new JacksonFactory();
}
