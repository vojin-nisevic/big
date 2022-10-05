package com.big.backend.modelsDto;

import com.big.backend.models.BackRow;
import com.big.backend.models.FrontRow;

import javax.validation.constraints.NotBlank;

public class PlayerDto {

    @NotBlank
    private Long id;
    private String currentName;
    private String originalName;
    private int castleLevel;
    private FrontRow frontRow;
    private BackRow backRow;
    public PlayerDto() {

    }

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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public int getCastleLevel() {
        return castleLevel;
    }

    public void setCastleLevel(int castleLevel) {
        this.castleLevel = castleLevel;
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
}
