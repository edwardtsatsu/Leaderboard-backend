package com.group8.Leaderboardbackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeaderboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderboardBackendApplication.class, args);
	}

}
