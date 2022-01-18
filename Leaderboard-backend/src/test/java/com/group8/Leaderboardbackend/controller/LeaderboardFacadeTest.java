package com.group8.Leaderboardbackend.controller;

import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.controller.response.ProfileResponse;
import com.group8.Leaderboardbackend.converter.ProfileToProfileDtoConverter;
import com.group8.Leaderboardbackend.service.LeaderboardRepositoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = LeaderboardFacade.class)
@ExtendWith(SpringExtension.class)
public class LeaderboardFacadeTest {
    @Autowired
    private LeaderboardFacade leaderboardFacade;

    @MockBean
    private LeaderboardRepositoryService leaderboardRepositoryService;

    @MockBean
    private ProfileToProfileDtoConverter profileToProfileDtoConverter;

    @Test
    void testGetLeaderboard() {

        //when
        when(this.leaderboardRepositoryService.getProfiles()).thenReturn(new ArrayList<>());
        List<ProfileDto> actualLeaderboard = this.leaderboardFacade.getLeaderboard();
        assertTrue(actualLeaderboard.isEmpty());

        //that
        verify(this.leaderboardRepositoryService).getProfiles();
        assertEquals(actualLeaderboard, this.leaderboardFacade.getLeaderboardByHonour());
    }

    @Test
    void testGetLeaderboardByHonour() {

        //when
        when(this.leaderboardRepositoryService.getProfiles()).thenReturn(new ArrayList<>());
        List<ProfileResponse> actualLeaderboardByHonour = this.leaderboardFacade.getLeaderboardByHonour();
        assertTrue(actualLeaderboardByHonour.isEmpty());
        verify(this.leaderboardRepositoryService).getProfiles();
        assertEquals(actualLeaderboardByHonour, this.leaderboardFacade.getLeaderboard());
    }

}
