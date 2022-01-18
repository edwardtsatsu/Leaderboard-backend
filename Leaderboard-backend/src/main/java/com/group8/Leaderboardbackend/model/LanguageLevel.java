package com.group8.Leaderboardbackend.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE_LEVELS")
@Data
@Accessors(chain = true)
@IdClass(LanguageLevelId.class)

public class LanguageLevel {
    @Id
    private Integer rank;

    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name="PROFILE_ID", nullable=false)
    private Profile profile;

}
