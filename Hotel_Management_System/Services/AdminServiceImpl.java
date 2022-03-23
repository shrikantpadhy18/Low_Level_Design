package Services;
import java.util.Arrays;
import java.util.List;

import Helper.AdminServiceHelper;
import Model.Hotel;
import Repository.*;
public class AdminServiceImpl implements AdminService {

    
    AdminServiceHelper adminHelper=new AdminServiceHelper();
    @Override
    public void initializeHotels() {
        store storeobj=new store();
        List<Hotel>hotelList= storeobj.getListOfHotel();
        hotelList=Arrays.asList(adminHelper.getListOfHotels());
        storeobj.setListOfHotel(hotelList); 
    }
    
}
