package com.bbarb75.laligastats.Entities;

import lombok.Setter;

public class Club {

    String clubName;
    int matchesPlayed;
    int clubGoalsScored;
    int goalsAllowed;

    public Club(String clubName, int matchesPlayed, int clubGoalsScored, int goalsAllowed){
        this.clubName = clubName;
        this.matchesPlayed = matchesPlayed;
        this.clubGoalsScored = clubGoalsScored;
        this.goalsAllowed = goalsAllowed;
    }


    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setClubGoalsScored(int clubGoalsScored) {
        this.clubGoalsScored = clubGoalsScored;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public String getClubName() {
        return clubName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getClubGoalsScored() {
        return clubGoalsScored;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public Club(){

    }
}
