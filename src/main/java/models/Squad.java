package models;

public class Squad {
    private String name;
    private String mission;
    private int participants;


    public Squad( String name, String mission, int participants){
        this.name = name;
        this.mission = mission;
        this.participants = participants;
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
}
