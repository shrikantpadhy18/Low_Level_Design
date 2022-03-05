package models;

public class Game {
    Player[] listofPlayer=new Player[2];
    TicTacBoard board;
    public Player[] getListofPlayer() {
        return listofPlayer;
    }
    public void setListofPlayer(Player[] listofPlayer) {
        this.listofPlayer = listofPlayer;
    }
    public TicTacBoard getBoard() {
        return board;
    }
    public void setBoard(TicTacBoard board) {
        this.board = board;
    }

    
}
