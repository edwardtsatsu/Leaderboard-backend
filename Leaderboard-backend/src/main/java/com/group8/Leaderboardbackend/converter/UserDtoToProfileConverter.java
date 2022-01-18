package com.group8.Leaderboardbackend.converter;

import com.group8.Leaderboardbackend.client.response.RankDto;
import com.group8.Leaderboardbackend.client.response.UserDto;
import com.group8.Leaderboardbackend.model.LanguageLevel;
import com.group8.Leaderboardbackend.model.Profile;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;


@Component
public class UserDtoToProfileConverter implements Converter<UserDto, Profile> {

    @Override
    @NonNull
    public Profile convert(UserDto source) {
        return new Profile()
                .setId(source.getUsername())
                .setName(source.getName())
                .setClan(source.getClan())
                .setHonour(source.getHonor())
                .setOverallRank(source.getRanks().getOverall().getRank())
                .setLanguageLevels(convertLanguages(source.getRanks().getLanguages()));
    }

    public List<LanguageLevel> convertLanguages(Map<String, RankDto> languages) {
        return languages.entrySet().stream()
                .map(entry -> new LanguageLevel()
                        .setName(entry.getKey())
                        .setRank(entry.getValue().getRank()))
                .collect(toList());
    }
}
