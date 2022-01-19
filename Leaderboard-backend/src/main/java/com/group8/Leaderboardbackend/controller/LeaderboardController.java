package com.group8.Leaderboardbackend.controller;
import com.group8.Leaderboardbackend.controller.response.OverallRankResponse;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import com.group8.Leaderboardbackend.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
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




    @GetMapping("language/{language}")
    public List<ProfileDto> getUsersByLanguage(@PathVariable("language") String language ){
        return leaderboardFacade.getLeaderboardByLanguage(language);
    }




}
