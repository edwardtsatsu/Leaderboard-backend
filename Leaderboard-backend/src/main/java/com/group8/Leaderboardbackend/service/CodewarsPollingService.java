package com.group8.Leaderboardbackend.service;

import com.group8.Leaderboardbackend.client.CodewarsClient;
import com.group8.Leaderboardbackend.converter.UserDtoToProfileConverter;
import com.group8.Leaderboardbackend.model.Profile;
import com.group8.Leaderboardbackend.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CodewarsPollingService {
    private final CodewarsClient codewarsClient;
    private final UserDtoToProfileConverter userDtoToProfileConverter;
    private final ProfileRepository profileRepository;

    @Scheduled(fixedDelay = 10000)
    public void updateProfiles() {
        profileRepository.findAll().stream()
                .map(Profile::getId)
                .map(codewarsClient::getUser)
                .filter(Objects::nonNull)
                .map(userDtoToProfileConverter::convert)
                .forEach(profileRepository::save);
    }
}
