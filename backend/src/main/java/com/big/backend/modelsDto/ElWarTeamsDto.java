package com.big.backend.modelsDto;

import com.big.backend.models.ElWarTeam;

import java.util.List;

public class ElWarTeamsDto {

    private ElWarTeam team;
    private int players;

    public ElWarTeamsDto() {
    }

    public ElWarTeamsDto(ElWarTeam team, int players) {
        this.team = team;
        this.players = players;
    }

    public ElWarTeam getTeam() {
        return team;
    }

    public void setTeam(ElWarTeam team) {
        this.team = team;
    }


    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }
}
