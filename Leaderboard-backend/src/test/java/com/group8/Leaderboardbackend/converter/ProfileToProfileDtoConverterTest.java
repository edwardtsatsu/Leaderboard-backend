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
        Profile profile = new Profile();
        profile.setClan("Clan");
        profile.setHonour(1);
        profile.setId("42");
        ArrayList<LanguageLevel> languageLevelList = new ArrayList<>();
        profile.setLanguageLevels(languageLevelList);
        profile.setName("Name");
        profile.setOverallRank(1);
        ProfileDto actualConvertResult = this.profileToProfileDtoConverter.convert(profile);
        assertEquals("Clan", actualConvertResult.getClan());
        assertEquals("42", actualConvertResult.getUsername());
        assertEquals(1, actualConvertResult.getOverallRank().intValue());
        assertEquals("Name", actualConvertResult.getName());
        assertEquals(languageLevelList, actualConvertResult.getLanguages());
        assertEquals(1, actualConvertResult.getHonour().intValue());
    }

    @Test
    void testConvertLanguages() {
        assertTrue(this.profileToProfileDtoConverter.convertLanguages(new ArrayList<>()).isEmpty());
    }

    @Test
    void testConvertLanguages2() {
        Profile profile = new Profile();
        profile.setClan("Clan");
        profile.setHonour(0);
        profile.setId("42");
        profile.setLanguageLevels(new ArrayList<>());
        profile.setName("Name");
        profile.setOverallRank(0);

        LanguageLevel languageLevel = new LanguageLevel();
        languageLevel.setName("Name");
        languageLevel.setProfile(profile);
        languageLevel.setRank(0);

        ArrayList<LanguageLevel> languageLevelList = new ArrayList<>();
        languageLevelList.add(languageLevel);
        List<LanguageLevelDto> actualConvertLanguagesResult = this.profileToProfileDtoConverter
                .convertLanguages(languageLevelList);
        assertEquals(1, actualConvertLanguagesResult.size());
        LanguageLevelDto getResult = actualConvertLanguagesResult.get(0);
        assertEquals("Name", getResult.getName());
        assertEquals(0, getResult.getRank().intValue());
    }

    @Test
    void testConvertLanguages3() {
        Profile profile = new Profile();
        profile.setClan("Clan");
        profile.setHonour(0);
        profile.setId("42");
        profile.setLanguageLevels(new ArrayList<>());
        profile.setName("Name");
        profile.setOverallRank(0);

        LanguageLevel languageLevel = new LanguageLevel();
        languageLevel.setName("Name");
        languageLevel.setProfile(profile);
        languageLevel.setRank(0);

        Profile profile1 = new Profile();
        profile1.setClan("Clan");
        profile1.setHonour(0);
        profile1.setId("42");
        profile1.setLanguageLevels(new ArrayList<>());
        profile1.setName("Name");
        profile1.setOverallRank(0);

        LanguageLevel languageLevel1 = new LanguageLevel();
        languageLevel1.setName("Name");
        languageLevel1.setProfile(profile1);
        languageLevel1.setRank(0);

        ArrayList<LanguageLevel> languageLevelList = new ArrayList<>();
        languageLevelList.add(languageLevel1);
        languageLevelList.add(languageLevel);
        List<LanguageLevelDto> actualConvertLanguagesResult = this.profileToProfileDtoConverter
                .convertLanguages(languageLevelList);
        assertEquals(2, actualConvertLanguagesResult.size());
        LanguageLevelDto getResult = actualConvertLanguagesResult.get(1);
        assertEquals(0, getResult.getRank().intValue());
        assertEquals("Name", getResult.getName());
        LanguageLevelDto getResult1 = actualConvertLanguagesResult.get(0);
        assertEquals(0, getResult1.getRank().intValue());
        assertEquals("Name", getResult1.getName());
    }
}
