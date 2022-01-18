package com.group8.Leaderboardbackend.client;
import com.group8.Leaderboardbackend.client.response.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import static java.lang.String.format;

@Component
@Slf4j
public class CodewarsClient {
    private static final String BASE_USERS_PATH = "users/%s";

    private final RestTemplate restTemplate;

    private final String codewarsUri;

    public CodewarsClient(RestTemplateBuilder restTemplateBuilder, @Value("${codewars-uri}") String codewarsUri) {
        this.restTemplate = restTemplateBuilder.build();
        this.codewarsUri = codewarsUri;
    }

    public UserDto getUser(String username) {
        UserDto result = null;
        try {
            result = restTemplate.getForObject(buildUrl(format(BASE_USERS_PATH, username)), UserDto.class);
        } catch (RestClientException e) {
            log.error("Exception getting user from Codewars API", e);
        }
        return result;
    }

    private String buildUrl(String path) {
        return codewarsUri + path;
    }
}
