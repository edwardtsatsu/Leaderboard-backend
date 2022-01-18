package com.group8.Leaderboardbackend.converter;

import com.group8.Leaderboardbackend.controller.response.LanguageLevelDto;
import com.group8.Leaderboardbackend.controller.response.ProfileDto;
import com.group8.Leaderboardbackend.model.LanguageLevel;
import com.group8.Leaderboardbackend.model.Profile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = ProfileToProfileDtoConverter.class)
@ExtendWith(SpringExtension.class)
public class ProfileToProfileDtoConverterTest {
    @Autowired
    private ProfileToProfileDtoConverter profileToProfileDtoConverter;

    @Test
    void testConvert() {
        //given
        Profile profile = new Profile();
        profile.setClan("turntabl");
        profile.setHonour(260);
        profile.setId("edwardtsatsu");

        ArrayList<LanguageLevel> languageLevelList = new ArrayList<>();
        profile.setLanguageLevels(languageLevelList);
        profile.setName("Akorlie Edward Tsatsu");
        profile.setOverallRank(-5);

        //when
        ProfileDto actualConvertResult = this.profileToProfileDtoConverter.convert(profile);

        //that
        assertEquals("turntabl", actualConvertResult.getClan());
        assertEquals("edwardtsatsu", actualConvertResult.getUsername());
        assertEquals(-5, actualConvertResult.getOverallRank().intValue());
        assertEquals("Akorlie Edward Tsatsu", actualConvertResult.getName());
        assertEquals(languageLevelList, actualConvertResult.getLanguages());
        assertEquals(260, actualConvertResult.getHonour().intValue());
    }



    @Test
    void testConvertLanguages() {

        //given
        Profile profile = new Profile();
        profile.setClan("turntabl");
        profile.setHonour(332);
        profile.setId("aweperi");
        profile.setLanguageLevels(new ArrayList<>());
        profile.setName("Adiba Aweperi Emmanuel");
        profile.setOverallRank(-5);

        LanguageLevel languageLevel = new LanguageLevel();
        languageLevel.setName("java");
        languageLevel.setProfile(profile);
        languageLevel.setRank(-5);

        //when
        ArrayList<LanguageLevel> languageLevelList = new ArrayList<>();
        languageLevelList.add(languageLevel);
        List<LanguageLevelDto> actualConvertLanguagesResult = this.profileToProfileDtoConverter.convertLanguages(languageLevelList);
        assertEquals(1, actualConvertLanguagesResult.size());
        LanguageLevelDto getResult = actualConvertLanguagesResult.get(0);

        assertEquals("java", getResult.getName());
        assertEquals(-5, getResult.getRank().intValue());
    }


}
