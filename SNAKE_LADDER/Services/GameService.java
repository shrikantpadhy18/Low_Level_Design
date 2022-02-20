package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import model.*;


public class GameService {
    Board board;
    int snakes;
    int ladder;
    int players;
    Map<Integer,Integer>snakepath=new HashMap<>();
    Map<Integer,Integer>ladderpath=new HashMap<>();
    List<Snake>snakeslist=new ArrayList<>();
    List<Ladder>ladderlist=new ArrayList<>();
    Queue<Player>playerlist=new LinkedList<Player>();
    public void initBoard(){    
        board=new Board();
        
    }
    public void setSnakes(){
        snakes=3;
        System.out.println("Setting snakes-------------------------->");

        int counter=0;
        while(counter<snakes){
            int randomNo1=(int) Math.floor(Math.random()*(100)+0);

            int randomNo2=(int) Math.floor(Math.random()*(100)+0);

            if(randomNo2>=randomNo1)
                continue;
            Snake snake=new Snake(randomNo1, randomNo2);
            counter+=1;
            snakepath.put(randomNo1,randomNo2);
            snakeslist.add(snake);
        }

    }
    public void setLadders(){
        ladder=3;
        System.out.println("Setting up ladders----------------->");
        int counter=0;
        while(counter<ladder){
            int randomNo1=(int) Math.floor(Math.random()*(99)+1);

            int randomNo2=(int) Math.floor(Math.random()*(99)+1);

            if(randomNo2>=randomNo1)
                continue;
            Ladder lad=new Ladder(randomNo1, randomNo2);
            counter+=1;
            ladderpath.put(randomNo1,randomNo2);
            ladderlist.add(lad);
        }
    }

    public void setPlayers(){
        System.out.println("setting players-------------------->");
        players=3;
        int counter=0;
        String[]names={"Shrikant","Prashant","Shubham"};
        int j=0;

        while(counter<players){
            Player players=new Player(0,names[j],0,0);
            counter+=1;
            j+=1;
            playerlist.offer(players);
        }
    }


    public void gameStarts(){
        System.out.println("Game Starts---------------->");
        DiceService gmservice=new DiceService();
        while(true){
            Player p1=playerlist.poll();
            int currstate=p1.getCurrposition();
            System.out.println("PlayerName:"+p1.getPlayername()+" turns now"+" currentstate->"+currstate);
            int randValue=gmservice.getRandom();
            int newstate=currstate+randValue;
            System.out.println("PlayerName:"+p1.getPlayername()+" newstate->"+newstate);
            if(newstate>99){
                this.playerlist.offer(p1);
            }
            else if(ladderpath.get(newstate)!=null){
                System.out.println("PlayerName:"+p1.getPlayername()+" newstate->"+newstate+" has ladder");
                newstate=ladderpath.get(newstate);
                p1.setCurrposition(newstate);
                System.out.println("PlayerName:"+p1.getPlayername()+"climbs the ladder reach the newstate->"+newstate);
                int newRow=this.board.getMapper().get(newstate)[0];
                int newCol=this.board.getMapper().get(newstate)[1];
                p1.setCol(newCol);
                p1.setRow(newRow);
                this.playerlist.offer(p1);
            }
            else if(snakepath.get(newstate)!=null){
                System.out.println("PlayerName:"+p1.getPlayername()+" newstate->"+newstate+" has snake");
                newstate=snakepath.get(newstate);
                p1.setCurrposition(newstate);
                System.out.println("PlayerName:"+p1.getPlayername()+"bitten by snake reach the newstate->"+newstate);
                int newRow=this.board.getMapper().get(newstate)[0];
                int newCol=this.board.getMapper().get(newstate)[1];
                p1.setCol(newCol);
                p1.setRow(newRow);
                this.playerlist.offer(p1);
            }
            else{
                p1.setCurrposition(newstate);
                int newRow=this.board.getMapper().get(newstate)[0];
                int newCol=this.board.getMapper().get(newstate)[1];
                p1.setCol(newCol);
                p1.setRow(newRow);
                this.playerlist.offer(p1);
            }

            if(newstate==99){
                System.out.println("GAME ENDS------------->"+p1.getPlayername()+"------------------->is the winner");
                break;
            }

            
        }


    }

    public GameService(){
        System.out.println("inside gameservice---------------->");
        initBoard();
        setLadders();
        setSnakes();
        setPlayers();
       Game game=new Game();
        
        game.setBoard(board);
        game.setLadderlist(ladderlist);
        game.setPlayerlist(playerlist);
        game.setSnakelist(snakeslist);

        displaySnakes(snakeslist);
        displayPlayers(playerlist);
        displayLadders(ladderlist);

        gameStarts();
    }
    private void displayLadders(List<Ladder>ls) {
        System.out.println("-->lets see the orientation of ladders in this game");
        for(Ladder lad:ls){
            System.out.println("Leader head:"+lad.getLadderhead()+" Ladder tail->"+lad.getLaddertail());
        }
    }
    private void displaySnakes(List<Snake>ls) {
        System.out.println("-->lets see the orientation of snakes in this game");
        for(Snake snake:ls){
            System.out.println("Snake head:"+snake.getSnakehead()+" Snake tail:"+snake.getSnaketail());
        }
    }
    private void displayPlayers(Queue<Player>ls) {
        System.out.println("-->lets see the players in this game");
        for(Player pl:ls){
            System.out.println("name="+pl.getPlayername()+" curr pos:"+pl.getCurrposition());
        }
    }
    
}
