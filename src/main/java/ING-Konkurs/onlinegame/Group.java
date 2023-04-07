package com.example.myapp;

import java.util.List;

public class Group {
    private List<Clan> clans;

    public Group() {
    }

    public Group(List<Clan> clans) {
        this.clans = clans;
    }

    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }
}
