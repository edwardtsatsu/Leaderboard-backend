package com.group8.Leaderboardbackend.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {


}
