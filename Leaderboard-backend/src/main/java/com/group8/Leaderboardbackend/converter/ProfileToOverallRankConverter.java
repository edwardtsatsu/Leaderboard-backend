package com.group8.Leaderboardbackend.converter;

import com.group8.Leaderboardbackend.controller.response.OverallRankResponse;
import com.group8.Leaderboardbackend.model.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileToOverallRankConverter implements Converter<Profile, OverallRankResponse> {

    @Override
    public OverallRankResponse convert(Profile source) {
        return OverallRankResponse.builder()
                .username(source.getId())
                .clan(source.getClan())
                .overallRank(source.getOverallRank()).build();
    }
}
