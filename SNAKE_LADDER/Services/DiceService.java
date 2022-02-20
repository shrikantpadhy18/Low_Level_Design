package Services;

import model.Dice;

public class DiceService {
    Dice dice=new Dice();

    public int getRandom(){
        System.out.println("Dice rolling has been started------->");
        int randomNo1=(int) Math.floor(Math.random()*(6)+1);
        System.out.println("Dice throws----------->"+randomNo1);
        return randomNo1;
    }

}
