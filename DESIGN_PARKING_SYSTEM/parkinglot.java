import java.util.Scanner;

class ParkingSpot{
    int spotno;
    boolean ispotempty=true;
    public int getSpotno() {
        return spotno;
    }
    public void setSpotno(int spotno) {
        this.spotno = spotno;
    }
    public boolean isIspotempty() {
        return ispotempty;
    }
    public void setIspotempty(boolean ispotempty) {
        this.ispotempty = ispotempty;
    }
   
}


class ParkingFloor{
    int Floorno;
    ParkingSpot[] spots;

    public int checkAvailabilty(){
        for(ParkingSpot data:spots){
            if(data.isIspotempty()){
                data.setIspotempty(false);
                return(data.getSpotno());
            }
        }
        return(-1);
    }

    

    public int getFloorno() {
        return Floorno;
    }

    public void setFloorno(int floorno) {
        Floorno = floorno;
    }

    public ParkingSpot[] getSpots() {
        return spots;
    }

    public void setSpots(ParkingSpot[] spots) {
        this.spots = spots;
    }

}

class DisplayBoard{
    int totalspotsfree;
    int totaloccupied;
    public int getTotalspotsfree() {
        return totalspotsfree;
    }
    public void setTotalspotsfree(int totalspotsfree) {
        this.totalspotsfree = totalspotsfree;
    }
    public int getTotaloccupied() {
        return totaloccupied;
    }
    public void setTotaloccupied(int totaloccupied) {
        this.totaloccupied = totaloccupied;
    }

    public void display(){
        System.out.println("TotalOccupied="+totaloccupied+"TotalfREEspot="+totalspotsfree);
    }
    
}

class ParkingLot
{
    int totalfloors;
    ParkingFloor[] floor;
    DisplayBoard obj;
    
    public void setObj(DisplayBoard obj) {
        this.obj = obj;
        this.obj.display();
        
    }
    public int getTotalfloors() {
        return totalfloors;
    }
    public void setTotalfloors(int totalfloors) {
        this.totalfloors = totalfloors;
        floor=new ParkingFloor[totalfloors];
    }
    public ParkingFloor[] getParkingFloor(){
        return(this.floor);
    }
    public DisplayBoard getDisplayBoard(){
        return(this.obj);
    }
    

    public void checkStatus(){
        int totaloccupied=0;
        int totalempty=0;

        for(ParkingFloor particularfloor:floor){
            for(ParkingSpot val:particularfloor.getSpots()){
                if(val.isIspotempty()){
                    totalempty+=1;
                }
                else{
                    totaloccupied+=1;
                }
            }            

        }

        this.obj.setTotaloccupied(totaloccupied);
        this.obj.setTotalspotsfree(totalempty);
        this.obj.display();

    }       
}

//category of vehicles in our parking
enum vehicleType{
    SMALL,MEDIUM,LARGE
}


//in future we can add other billing options if required
interface billing{
    public void transaction(String x);
}


// billing depends on type of vehicle being parked
class CreditPayment implements billing{
    public void transaction(String type){
        if(type==vehicleType.LARGE.toString()){
                //do billing for large vehicle type
        }
        else if(type==vehicleType.SMALL.toString()){
            //DO BILLING FOR SMALL VEHICLE TYPE
        }
        else{
            //DO BILLING FOR MEDIUM VEHICLE TYPE
        }
    }
}



class Context{
    public boolean executePayment(String paymentType,String vehicletype){
        billing bill;
        if(paymentType.equals("creditPayment")){
            bill=new CreditPayment();
            bill.transaction(vehicletype);
            return true;
        }

        return(false);
    }
}

class Starter{
    public static void main(String[] args){
        //created a parking lot
        Context ctx=new Context();
        ParkingLot lot=new ParkingLot();
        //number of floors parking lot will have
        lot.setTotalfloors(12);
        //added displayboard
        lot.setObj(new DisplayBoard());

        

        Scanner sc=new Scanner(System.in);
        String vehicle=sc.nextLine();

        //WHENEVER VEHICLES COME
        //this will display the board with total vacant spot,filled spot etc
        lot.checkStatus();
        
        for(int i=1;i<=12;i++){
            ParkingFloor[] arr= lot.getParkingFloor();

            int spotno=arr[i].checkAvailabilty();
            if(spotno!=-1){
                if(ctx.executePayment("creditPayment", "SMALL")){
                    arr[i].getSpots()[spotno].setIspotempty(false);
                    lot.getDisplayBoard().display();
                    System.out.println("Parking Slot Booked");
                }
                else{
                    System.out.println("Retry..booking Failed");
                }
            }

        }
    

    }
}