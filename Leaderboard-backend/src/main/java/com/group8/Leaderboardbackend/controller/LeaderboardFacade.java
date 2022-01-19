package com.group8.Leaderboardbackend.controller;

import com.group8.Leaderboardbackend.controller.response.OverallRankResponse;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import com.group8.Leaderboardbackend.converter.ProfileToOverallRankConverter;
import com.group8.Leaderboardbackend.converter.ProfileToProfileDtoConverter;
import com.group8.Leaderboardbackend.converter.ProfileToProfileResponseConverter;
import com.group8.Leaderboardbackend.model.Profile;
import com.group8.Leaderboardbackend.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class LeaderboardFacade {
    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;
    private final ProfileToProfileResponseConverter profileToProfileResponseConverter;
    private final ProfileToOverallRankConverter profileToOverallRankConverter;


    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }


    public List<ProfileResponse> getLeaderboardByHonour(){
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileResponseConverter::convert)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(ProfileResponse::getHonour).reversed())
                .collect(toList());

    }


    public List<OverallRankResponse> getLeaderboardByRank(){
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToOverallRankConverter::convert)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(OverallRankResponse::getOverallRank).reversed())
                .collect(toList());


    }

    public List<ProfileDto> getLeaderboardByLanguage(String language){
        return leaderboardRepositoryService.getProfiles().stream()
                .filter(x->x.getLanguageLevels().stream().anyMatch(y->y.getName().equals(language)))
                .sorted(Comparator.comparingInt(Profile::getHonour).reversed())
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());

    }



}
