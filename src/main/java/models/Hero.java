package models;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroPower;
    private  String heroWeakness;
    private String content;



    public Hero(String name, int age, String power, String weakness){
        this.heroName = name;
        this.heroAge = age;
        this.heroPower = power;
        this.heroWeakness = weakness;
    }

    public String getContent() {
        return content;
    }
}
