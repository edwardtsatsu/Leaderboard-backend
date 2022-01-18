package com.group8.Leaderboardbackend.controller;

import com.group8.Leaderboardbackend.controller.response.OverallRankResponse;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import com.group8.Leaderboardbackend.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/leaderboard")
public class LeaderboardController {
    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @GetMapping("/honour")
    public List<ProfileResponse> getLeaderboardByHonour(){
        return leaderboardFacade.getLeaderboardByHonour();

    }

    @GetMapping("/overallRank")
    public List<OverallRankResponse> getLeaderboardByRank(){
        return leaderboardFacade.getLeaderboardByRank();
    }

    @PostMapping
    public void createProfile(@RequestBody Profile profile) {
        leaderboardFacade.createProfile(profile);
    }

}
