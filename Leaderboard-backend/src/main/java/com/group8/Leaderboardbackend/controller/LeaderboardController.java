package com.group8.Leaderboardbackend.controller;

import com.group8.Leaderboardbackend.controller.response.OverallRankResponse;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/leaderboard")
@Api(value = "Leaderboard Service", description = "Leaderboard Application")
public class LeaderboardController {
    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    @ApiOperation(value = "Get All Profiles api")
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @GetMapping("/honour")
    @ApiOperation(value = "Get Profile Ordered By Honour api")
    public List<ProfileResponse> getLeaderboardByHonour(){
        return leaderboardFacade.getLeaderboardByHonour();

    }

    @GetMapping("/overallRank")
    @ApiOperation(value = "Get Profile Ordered By Overall_Rank api")
    public List<OverallRankResponse> getLeaderboardByRank(){
        return leaderboardFacade.getLeaderboardByRank();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Create Profile api")
    public ProfileDto addUser(@RequestBody Profile username) {
        return leaderboardFacade.addUser(username);
    }


    @GetMapping("language/{language}")
    @ApiOperation(value = "Get Profile By Language api")
    public List<ProfileDto> getUsersByLanguage(@PathVariable("language") String language ){
        return leaderboardFacade.getUsersByCommonLanguage(language);
    }




}
