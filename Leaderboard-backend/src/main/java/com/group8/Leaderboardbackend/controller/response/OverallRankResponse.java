package com.group8.Leaderboardbackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OverallRankResponse {
    String username;


    String clan;

    @JsonProperty(value = "overall_rank")
    Integer overallRank;



}

