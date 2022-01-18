package com.group8.Leaderboardbackend.converter;
import com.group8.Leaderboardbackend.controller.response.LanguageLevelDto;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.model.LanguageLevel;
import com.group8.Leaderboardbackend.model.Profile;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Component
public class ProfileToProfileDtoConverter implements Converter<Profile, ProfileDto> {


    @Override
    public ProfileDto convert(Profile source) {
        return ProfileDto.builder()
                .username(source.getId())
                .name(source.getName())
                .clan(source.getClan())
                .honour(source.getHonour())
                .overallRank(source.getOverallRank())
                .languages(convertLanguages(source.getLanguageLevels()))
                .build();
    }

    public List<LanguageLevelDto> convertLanguages(List<LanguageLevel> languageLevels) {
        return languageLevels.stream()
                .map(languageLevel -> LanguageLevelDto.builder()
                        .name(languageLevel.getName())
                        .rank(languageLevel.getRank())
                        .build())
                .collect(toList());
    }

}
