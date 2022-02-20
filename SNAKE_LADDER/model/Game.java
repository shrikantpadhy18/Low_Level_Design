package model;

import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> playerlist;
    List<Snake>snakelist;
    List<Ladder>ladderlist;
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Queue<Player> getPlayerlist() {
        return playerlist;
    }
    public void setPlayerlist(Queue<Player> playerlist2) {
        this.playerlist = playerlist2;
    }
    public List<Snake> getSnakelist() {
        return snakelist;
    }
    public void setSnakelist(List<Snake> snakelist) {
        this.snakelist = snakelist;
    }
    public List<Ladder> getLadderlist() {
        return ladderlist;
    }
    public void setLadderlist(List<Ladder> ladderlist) {
        this.ladderlist = ladderlist;
    }
}
