package com.group8.Leaderboardbackend.client.response;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class UserDto {

    String username;

    String name;

    String clan;

    Integer honor;

    RanksDto ranks;


}
