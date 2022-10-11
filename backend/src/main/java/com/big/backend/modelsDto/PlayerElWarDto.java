package com.big.backend.modelsDto;

import com.big.backend.models.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PlayerElWarDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String currentName;

    @NotBlank
    private int marchSize;

    @Min(1)
    @Max(40)
    @Column(nullable = false)
    private int castleLevel;

    @NotBlank
    private int hp;

    @NotBlank
    private int attack;

    @NotBlank
    private FrontRow frontRow;

    @NotBlank
    private BackRow backRow;

    @NotBlank
    private ElWarTeam ewTeam;

    public PlayerElWarDto() {
    }

    //region GET SET

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public int getMarchSize() {
        return marchSize;
    }

    public void setMarchSize(int marchSize) {
        this.marchSize = marchSize;
    }

    public int getCastleLevel() {
        return castleLevel;
    }

    public void setCastleLevel(int castleLevel) {
        this.castleLevel = castleLevel;
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

    public ElWarTeam getEwTeam() {
        return ewTeam;
    }

    public void setEwTeam(ElWarTeam ewTeam) {
        this.ewTeam = ewTeam;
    }

    //endregion
}
