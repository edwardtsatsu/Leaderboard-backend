package com.group8.Leaderboardbackend.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@Table(name = "PROFILES")
@Entity
@Data
@Accessors(chain = true)
public class Profile {
    @Id
    private String id;

    private String name;

    private String clan;

    private Integer honour;

    private Integer overallRank;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LanguageLevel> languageLevels;

    public Profile setLanguageLevels(List<LanguageLevel> languageLevels) {
        for (LanguageLevel languageLevel: languageLevels) {
            languageLevel.setProfile(this);
        }
        this.languageLevels = languageLevels;
        return this;
    }
}
