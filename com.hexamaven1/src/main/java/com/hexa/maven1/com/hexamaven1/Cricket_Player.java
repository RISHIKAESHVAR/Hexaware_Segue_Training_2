package com.hexa.maven1.com.hexamaven1;

public class Cricket_Player {
    private int playerId;
    private String name;
    private int runsScored;

    // Default constructor
    public Cricket_Player() {}

    // Getter and Setter for playerId
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for runsScored
    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    // toString method
    @Override
    public String toString() {
        return "Cricket_Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", runsScored=" + runsScored +
                '}';
    }
}
