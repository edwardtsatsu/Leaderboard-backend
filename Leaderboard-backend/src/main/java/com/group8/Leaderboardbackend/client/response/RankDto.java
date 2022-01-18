package com.group8.Leaderboardbackend.client.response;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class RankDto {

    Integer rank;

}
