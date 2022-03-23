package Helper;

import java.util.ArrayList;
import java.util.List;

import Model.Floor;
import Model.Hotel;
import Model.Room;

public class AdminServiceHelper {
    String [] namesOfHotel=new String[]{"Bajaj","Metro","Carwale","Raddi","Tokyos","Rammer","Pasta","Jiroc","Prasadam","Yak"};
    Hotel []listOfHotel=new Hotel[10];
    public Hotel[] getListOfHotels(){
        return(listOfHotel);
    }
    public AdminServiceHelper(){
        for(int i=0;i<10;i++){
            listOfHotel[i]=createHotel(i);
        }
    }


    public Hotel createHotel(int index){
        Hotel hotel=new Hotel();

        hotel.setName(namesOfHotel[index]);

        createListOfFloor(hotel);

        return(hotel);
    }

    public void createListOfFloor(Hotel hotel){
        List<Floor>listOfFloor=new ArrayList<>();

        int totalFloors=13;
        
        for(int i=0;i<totalFloors;i++){
            Floor floorObj=createFloor(i);
            listOfFloor.add(floorObj);
        }
        hotel.setListOfFloor(listOfFloor);

    }

    public Floor createFloor(int floor_no){
        Floor floorObj=new Floor();
        floorObj.setFloor_no(floor_no);
        List<Room>listOfRooms=getRoomList();
        floorObj.setRoomList(listOfRooms);
        return(floorObj);
    }
    public List<Room>getRoomList(){
        List<Room>listOfRooms=new ArrayList<>();
        int totalRoom=10;
        for(int i=0;i<totalRoom;i++){
            Room roomObj=createRoom(i);
            listOfRooms.add(roomObj);
        }
        return(listOfRooms);

    }
    
    public Room createRoom(int i){
        String []userTypes=new String[]{"deluxe","suite","ordinary","deluxe","suite","ordinary","deluxe","suite","ordinary","deluxe"};
        Boolean []isOccupied=new Boolean[]{true,false,true,false,true,false,true,false,true,false};
        Room roomObj=new Room();
        roomObj.setRoomId(Integer.toString(i));
        roomObj.setRoomType(userTypes[i]);
        roomObj.setRoomOccupied(isOccupied[i]);

        roomObj.setRoomCheckedIn(null);
        roomObj.setRoomCheckedOut(null);
        return(roomObj);

        
    }    


}
