package model;

public class Player {
    int currposition=0;
    String playername;
    int row=0;
    int col=0;
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    
    public int getCurrposition() {
        return currposition;
    }
    public void setCurrposition(int currposition) {
        this.currposition = currposition;
    }
    public String getPlayername() {
        return playername;
    }
    public void setPlayername(String playername) {
        this.playername = playername;
    }
    public Player(int currposition, String playername, int row, int col) {
        this.currposition = currposition;
        this.playername = playername;
        this.row = row;
        this.col = col;
    }


}
