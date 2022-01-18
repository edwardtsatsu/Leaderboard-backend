package com.group8.Leaderboardbackend.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import static java.util.stream.Collectors.toList;
import java.util.Comparator;
import java.util.Objects;

@RequiredArgsConstructor
@Component
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
}
