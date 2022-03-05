import services.GameServiceImpl;

public class Driver {
    public static void main(String[] args) {
        GameServiceImpl service=GameServiceImpl.getInstance();
        service.startGame();    
    }
}
