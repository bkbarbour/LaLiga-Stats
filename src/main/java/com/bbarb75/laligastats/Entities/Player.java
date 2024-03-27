package com.bbarb75.laligastats.Entities;

public class Player {
    String playerName;
    int goalsScored;
    int assistsGiven;
    int matchesPlayed;

    public Player(String playerName, int goalsScored, int assistsGiven, int matchesPlayed) {
        this.playerName = playerName;
        this.goalsScored = goalsScored;
        this.assistsGiven = assistsGiven;
        this.matchesPlayed = matchesPlayed;
    }

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssistsGiven() {
        return assistsGiven;
    }

    public void setAssistsGiven(int assistsGiven) {
        this.assistsGiven = assistsGiven;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
