package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Hotel;

public class   store{
    static Map<String,List<Hotel>>hotelStructure;
    static List<Hotel>listOfHotel;
    public store(){
        hotelStructure=new HashMap<>();
        listOfHotel=new ArrayList<>();
    }
    public  Map<String, List<Hotel>> getInstance(){
        return(hotelStructure);
    }
    public  List<Hotel>getListOfHotel(){
        return(listOfHotel);
    }
    public void setListOfHotel(List<Hotel>hotelList){
        listOfHotel=hotelList;
    }


    // this will  group list of hotel based on the location


}
