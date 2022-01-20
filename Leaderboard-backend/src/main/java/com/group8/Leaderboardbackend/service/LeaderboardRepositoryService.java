package com.group8.Leaderboardbackend.service;

import com.group8.Leaderboardbackend.model.Profile;
import com.group8.Leaderboardbackend.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardRepositoryService {
    private final ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }


    public Profile createProfile(Profile profile){
        return profileRepository.save(profile);
    }

}
