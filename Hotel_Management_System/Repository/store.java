package Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Hotel;

class   store{
    static Map<String,List<Hotel>>hotelStructure;
    public store(){
        hotelStructure=new HashMap<>();
    }
    public static Map<String, List<Hotel>> getInstance(){
        return(hotelStructure);
    }
    // this will  group list of hotel based on the location


}
