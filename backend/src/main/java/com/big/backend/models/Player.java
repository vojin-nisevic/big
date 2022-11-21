package com.big.backend.models;

import com.big.backend.modelsDto.PlayerDto;
import com.big.backend.modelsDto.PlayerElWarDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ColumnDefault("0")
    private Long killCount;

    //Health points
    @Min(0)
    @Column(nullable = false)
    @ColumnDefault("0")
    private int hp;

    //back row troops attack
    @Min(0)
    @Column(nullable = false)
    @ColumnDefault("0")
    private int attack;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "frontrow_id", foreignKey = @ForeignKey(name = "FK_PLAYER_FRONT_ROW"))
//    @JsonBackReference
    private FrontRow frontRow;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "backrow_id", foreignKey = @ForeignKey(name = "FK_PLAYER_BACK_ROW"))
//    @JsonBackReference
    private BackRow backRow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ewteam_id", foreignKey = @ForeignKey(name = "FK_PLAYER_EL_WAR_TEAM"))
//    @JsonBackReference
    private ElWarTeam ewTeam;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "merit_rank", foreignKey = @ForeignKey(name = "FK_PLAYER_MERIT_RANK"))
//    @JsonBackReference
    private MeritRank meritRank;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "alliance_rank_id", foreignKey = @ForeignKey(name = "FK_PLAYER_ALLIANCE_RANK"))
//    @JsonBackReference
    private AllianceRank allianceRank;

    @Transient
    public PlayerDto toDto() {
        PlayerDto dto = new PlayerDto();
        dto.setId(id);
        dto.setOriginalName(originalName);
        dto.setCurrentName(currentName);
        dto.setCastleLevel(castleLevel);
        dto.setFrontRow(frontRow);
        dto.setBackRow(backRow);
        return dto;
    }

    @Transient
    public PlayerElWarDto toElWarDto() {
        PlayerElWarDto dto = new PlayerElWarDto();
        dto.setId(id);
        dto.setCurrentName(currentName);
        dto.setMarchSize(marchSize);
        dto.setCastleLevel(castleLevel);
        dto.setHp(hp);
        dto.setAttack(attack);
        dto.setFrontRow(frontRow);
        dto.setBackRow(backRow);
        dto.setEwTeam(ewTeam);
        return dto;
    }

    //region constructors
    public Player(String originalName, String currentName, int marchSize, int timeZone, int castleLevel, Long killCount,
                  FrontRow frontRow, BackRow backRow, ElWarTeam ewTeam, MeritRank meritRank, AllianceRank allianceRank) {
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

    public void setId(Long id) {
        this.id = id;
    }


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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public FrontRow getFrontRow() {
        return frontRow;
    }

    public void setFrontRow(FrontRow frontRow) {
        this.frontRow = frontRow;
    }

    public BackRow getBackRow() {
        return backRow;
    }

    public void setBackRow(BackRow backRow) {
        this.backRow = backRow;
    }

    public int getMarchSize() {
        return marchSize;
    }

    public void setMarchSize(int marchSize) {
        this.marchSize = marchSize;
    }

    public ElWarTeam getEwTeam() {
        return ewTeam;
    }

    public void setEwTeam(ElWarTeam ewTeam) {
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
