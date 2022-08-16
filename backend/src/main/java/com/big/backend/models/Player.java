package com.big.backend.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Size(min = 2, max = 16)
    @Column(nullable = false, unique = true, length = 16)
    private String originalName;

    @Size(min = 2, max = 16)
    @Column(nullable = false, unique = true, length = 16)
    private String currentName;

    @Min(1)
    @Max(40)
    @Column(nullable = false)
    private int castleLevel;

    @Min(0)
    @Column(nullable = false)
    private Long killCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ewteam_id")
    private Ewteam ewTeam;


    //region constructors
    public Player(String originalName, String currentName, int castleLevel, Long killCount) {
        this.originalName = originalName;
        this.currentName = currentName;
        this.castleLevel = castleLevel;
        this.killCount = killCount;
    }

    public Player() {
    }

    //endregion

    //region getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public int getCastleLevel() {
        return castleLevel;
    }

    public void setCastleLevel(int castleLevel) {
        this.castleLevel = castleLevel;
    }

    public Long getKillCount() {
        return killCount;
    }

    public void setKillCount(Long killCount) {
        this.killCount = killCount;
    }

    public Ewteam getEwTeam() {
        return ewTeam;
    }

    public void setEwTeam(Ewteam ewTeam) {
        this.ewTeam = ewTeam;
    }

    //endregion


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", currentName='" + currentName + '\'' +
                ", castleLevel=" + castleLevel +
                ", killCount=" + killCount +
                '}';
    }
}
