package com.group8.Leaderboardbackend.converter;

import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import com.group8.Leaderboardbackend.model.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileToProfileResponseConverter implements Converter<Profile, ProfileResponse> {
    @Override
    public ProfileResponse convert(Profile source) {
        return ProfileResponse.builder()
                .username(source.getId())
                .name(source.getName())
                .clan(source.getClan())
                .honour(source.getHonour()).build();
    }
}
