package Model;

import java.util.Date;

public class Room
{
    String roomId;
    String RoomType;
    boolean isRoomOccupied;
    Date roomCheckedIn;
    Date roomCheckedOut;
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getRoomType() {
        return RoomType;
    }
    public void setRoomType(String roomType) {
        RoomType = roomType;
    }
    public boolean isRoomOccupied() {
        return isRoomOccupied;
    }
    public void setRoomOccupied(boolean isRoomOccupied) {
        this.isRoomOccupied = isRoomOccupied;
    }
    public Date getRoomCheckedIn() {
        return roomCheckedIn;
    }
    public void setRoomCheckedIn(Date roomCheckedIn) {
        this.roomCheckedIn = roomCheckedIn;
    }
    public Date getRoomCheckedOut() {
        return roomCheckedOut;
    }
    public void setRoomCheckedOut(Date roomCheckedOut) {
        this.roomCheckedOut = roomCheckedOut;
    }

    
}