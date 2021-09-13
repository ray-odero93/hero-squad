package models;

import java.util.ArrayList;

public class Squad {
    private static int squadId;
    private int id;
    private String name;
    private String mission;
    private int participants;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private ArrayList<Hero> members = new ArrayList<>();


    public Squad( String name, String mission, int participants){
        this.name = name;
        this.mission = mission;
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public static Squad findSquadById() {
        return instances.get(squadId-1);
    }

    public String getName() {
        return name;
    }


    public String getMission() {
        return mission;
    }

    public int getLimit() {
        return participants;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public void addSquadMembers(Hero hero) {
        members.add(hero);
    }

    public ArrayList<Hero> getSquadMembers() {
        return members;
    }

//    public static void clearSquadsList() {
//        instances.clear();
//    }

//    public void clearMembersList() {
//        getSquadMembers().clear();
//    }
}
