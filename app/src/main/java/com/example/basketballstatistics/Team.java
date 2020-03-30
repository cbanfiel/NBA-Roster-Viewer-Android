package com.example.basketballstatistics;

import java.util.ArrayList;

public class Team {

    private String name;
    private String url;
    private ArrayList<Player> roster;
    private int conferenceId;

    public Team(String name, String url, int conferenceId) {
        this.name = name;
        this.url = url;
        this.conferenceId = conferenceId;
        this.roster = new ArrayList<>();
    }

    public String getConference(){
        if(conferenceId == 0){
            return "Eastern Conference";
        }
        if(conferenceId == 1){
            return "Western Conference";
        }

        return "";
    }

    public void addPlayer(Player player){
        roster.add(player);
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<Player> getRoster() {
        return roster;
    }
}
