package com.big.backend.models;

public class PlayerIds {
    Long[] playerIdList;

    public PlayerIds(Long[] playerIdList) {
        this.playerIdList = playerIdList;
    }

    public PlayerIds() {
    }

    public Long[] getPlayerIdList() {
        return playerIdList;
    }

    public void setPlayerIdList(Long[] playerIdList) {
        this.playerIdList = playerIdList;
    }
}
