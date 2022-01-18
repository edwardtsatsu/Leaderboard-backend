package com.group8.Leaderboardbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LeaderboardController.class)
public class LeaderboardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LeaderboardFacade leaderboardFacade;

    @Test
    void shouldGetLeaderboard() throws Exception {
        //given
        ProfileDto profileDto = ProfileDto.builder()
                .username("edwardtsatsu")
                .name("Ana Lameira")
                .build();

        List<ProfileDto> expectedResponse = List.of(profileDto);


        //when
        when(leaderboardFacade.getLeaderboard()).thenReturn(expectedResponse);


        //that
        mockMvc.perform(get("/v1/leaderboard"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().
                        getContentAsString()).isEqualTo(objectMapper.writeValueAsString(expectedResponse)));
    }
}
