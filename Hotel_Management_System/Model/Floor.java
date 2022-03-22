package Model;

import java.util.List;

public class Floor {
    List<Room>roomList;
    int floor_no;
    public List<Room> getRoomList() {
        return roomList;
    }
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
    public int getFloor_no() {
        return floor_no;
    }
    public void setFloor_no(int floor_no) {
        this.floor_no = floor_no;
    }
    
}
