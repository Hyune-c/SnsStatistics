package com.albacheck.statistics.summary.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@DisplayName("SummaryController")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SummaryControllerTest {

  @Test
  void findStatistics() {
  }

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("통계 가져오기")
  @Nested
  public class FindStatistics {

    @DisplayName("요약")
    @Test
    void youtube() throws Exception {
      // given
      String testUrlPath = "/v1/statistics";

      // when
      MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(testUrlPath);
      ResultActions resultActions = mockMvc.perform(requestBuilder)
          .andDo(print());

      // then
      resultActions.andExpect(status().isOk())
          .andExpect(jsonPath("$.youtube").isNotEmpty())
          .andExpect(jsonPath("$.instagram").isNotEmpty());
    }
  }
}