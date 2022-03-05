package models;

public class Player
{
    String name;
    int state;
    public String getName() {
        return name;
    }
    public Player(String name, int state) {
        this.name = name;
        this.state = state;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }


}