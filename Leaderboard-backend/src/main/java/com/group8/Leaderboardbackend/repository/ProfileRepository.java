package com.group8.Leaderboardbackend.repository;
import com.group8.Leaderboardbackend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

}
