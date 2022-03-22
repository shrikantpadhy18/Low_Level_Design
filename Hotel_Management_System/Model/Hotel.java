package Model;

import java.util.List;

public class Hotel {
    String name;
    List<Floor>listOfFloor;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Floor> getListOfFloor() {
        return listOfFloor;
    }
    public void setListOfFloor(List<Floor> listOfFloor) {
        this.listOfFloor = listOfFloor;
    }
    
}
