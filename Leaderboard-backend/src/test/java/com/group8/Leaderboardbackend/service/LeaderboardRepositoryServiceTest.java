package com.group8.Leaderboardbackend.service;

import com.group8.Leaderboardbackend.model.Profile;
import com.group8.Leaderboardbackend.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LeaderboardRepositoryServiceTest {
    @Mock
    private ProfileRepository profileRepository;

    private LeaderboardRepositoryService underTest;

    @BeforeEach
    void setUp() {
        underTest = new LeaderboardRepositoryService(profileRepository);
    }

    @Test
    void shouldGetProfiles() {
        // given
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);

        when(profileRepository.findAll()).thenReturn(List.of(profile1, profile2));

        // when
        List<Profile> result = underTest.getProfiles();

        // then
        assertThat(result).containsExactly(profile1, profile2);

    }


    @Test
    void shouldCreateProfile() {
        //given
//        String profile = mock(Profile.class);

        //when
//        underTest.createProfile(profile);

        //then
        ArgumentCaptor<Profile> profileArgumentCaptor =
                ArgumentCaptor.forClass(Profile.class);

        //verifying if the profileRepository was called with the save method
        //and profileArgumentCaptor.capture() captures the actual profile that was pass inside the save method
        verify(profileRepository).save(profileArgumentCaptor.capture());

        Profile capturedProfile = profileArgumentCaptor.getValue();

//        assertThat(capturedProfile).isEqualTo(profile);
    }

}
