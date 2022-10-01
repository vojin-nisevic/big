package com.big.backend.models;

import org.hibernate.annotations.ColumnDefault;

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

    @Min(50000)
    @Column(nullable = false)
    private int marchSize;



    @Min(-12)
    @Max(12)
    @Column(nullable = false)
    @ColumnDefault("0")
    private int timeZone;

    @Min(1)
    @Max(40)
    @Column(nullable = false)
    private int castleLevel;

    @Min(0)
    @Column(nullable = false)
    private Long killCount;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "frontrow_id")
    private FrontRow frontRow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backrow_id")
    private BackRow backRow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ewteam_id")
    private Ewteam ewTeam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "merit_rank")
    private MeritRank meritRank;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alliance_rank_id")
    private AllianceRank allianceRank;



    //region constructors
    public Player(String originalName, String currentName, int marchSize, int timeZone, int castleLevel, Long killCount,
                  FrontRow frontRow, BackRow backRow, Ewteam ewTeam, MeritRank meritRank, AllianceRank allianceRank) {
        this.originalName = originalName;
        this.currentName = currentName;
        this.marchSize = marchSize;
        this.timeZone = timeZone;
        this.castleLevel = castleLevel;
        this.killCount = killCount;
        this.frontRow = frontRow;
        this.backRow = backRow;
        this.ewTeam = ewTeam;
        this.meritRank = meritRank;
        this.allianceRank = allianceRank;
    }

    public Player() {
    }

    //endregion

    //region getters and setters

    public Long getId() {
        return id;
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

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
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

    public int getMarchSize() {
        return marchSize;
    }

    public void setMarchSize(int marchSize) {
        this.marchSize = marchSize;
    }

    public Ewteam getEwTeam() {
        return ewTeam;
    }

    public void setEwTeam(Ewteam ewTeam) {
        this.ewTeam = ewTeam;
    }

    public MeritRank getMeritRank() {
        return meritRank;
    }

    public void setMeritRank(MeritRank meritRank) {
        this.meritRank = meritRank;
    }

    public AllianceRank getAllianceRank() {
        return allianceRank;
    }

    public void setAllianceRank(AllianceRank allianceRank) {
        this.allianceRank = allianceRank;
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
