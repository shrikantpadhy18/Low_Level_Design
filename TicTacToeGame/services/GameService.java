package services;

import java.util.Set;

import models.Player;

public interface GameService {
    
    public void setPlayers();
    public void setBoard();
    public void startGame();
    public void endGame(Player p);
    public int[][] initializeMatrix(int[][]m);
    public int generateRandom();
    public boolean checkIfPlayerWon(Player p);
    public int  checkValidity(Set<Integer>s);
}
