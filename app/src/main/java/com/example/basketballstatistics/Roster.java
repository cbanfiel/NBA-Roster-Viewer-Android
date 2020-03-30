package com.example.basketballstatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Roster {

    public static ArrayList<Team> teams;
    public static Team selected;


    public static void sortTeams(){
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

}
