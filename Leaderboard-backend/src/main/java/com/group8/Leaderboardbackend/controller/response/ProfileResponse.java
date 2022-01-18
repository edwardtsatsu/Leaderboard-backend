package com.group8.Leaderboardbackend.controller.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProfileResponse {
    String username;

    String name;

    String clan;

    Integer honour;
}
