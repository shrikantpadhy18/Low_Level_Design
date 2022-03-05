package services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import models.Game;
import models.Player;
import models.TicTacBoard;

public class GameServiceImpl  implements GameService{
    TicTacBoard board;
    Game game=new Game();
    Queue<Player>queue=new LinkedList<>();
    Set<Integer>visitedRow=new HashSet<>();
    Set<Integer>visitedCol=new HashSet<>();
    int[][]matrix;
    int counter=0;
    private static GameServiceImpl service=new GameServiceImpl();
    private GameServiceImpl(){
        setBoard();
        setPlayers();

    }
    public static GameServiceImpl getInstance(){
        return(service);
    }


    @Override
    public void startGame() {
        matrix=game.getBoard().getMatrix();
        Player[]playerList=game.getListofPlayer();
        queue.offer(playerList[0]);
        
        while(true)
        {
            Player playerData=queue.poll();
            int row;
            int col;
            row=checkValidity(visitedRow);
            col=checkValidity(visitedCol);
            matrix[row][col]=playerData.getState();
            if(checkIfPlayerWon(playerData))
            {
                endGame(playerData);
                break;
            }
            if(visitedRow.size()==3 && visitedCol.size()==3)
            {
                System.out.println("Game Drawn");
                break;
            }
            
            queue.offer(playerData);
        }

    }

    @Override
    public void endGame(Player p) {
       System.out.println(p.getName()+" won the game"+" having state of "+p.getState());
       
       System.out.println("The Final State of board");
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println();
       }

    }

    @Override
    public void setPlayers() {
        Player p1=new Player("Shrikant Padhy",0);
        Player p2=new Player("Akshay Pawar", 1);     
        Player[] listOfPlayer=new Player[2];
        listOfPlayer[0]=p1;
        listOfPlayer[1]=p2;
        game.setListofPlayer(listOfPlayer);

        
    }

    @Override
    public void setBoard() {
        board=new TicTacBoard();
        int[][]matrix=board.getMatrix();
        matrix=initializeMatrix(matrix);
        board.setMatrix(matrix);
        game.setBoard(board);
    }

    @Override
    public int[][] initializeMatrix(int[][] m) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m[i][j]=-1;
            }
        }
        return m;
    }

    @Override
    public int generateRandom() {
       int random=(int)Math.floor(Math.random()*(2-0+1)+0); //(max-min+1)*random()+min--->generate random value from min to max
        return(random);
    }

    @Override
    public boolean checkIfPlayerWon(Player p) {
        boolean ans=true;
        int size=3;
        int j=0;
        
        //check diagonals
        for(int i=0;i<3;i++){
            if(matrix[i][j]==p.getState()){
                
            }
            else
            {
                ans=false;
                break;
            }
            counter+=(matrix[i][j]==-1)?1:0;
            j+=1;
            
        }
        if(ans)
        return(ans);

        j=2;
        for(int i=0;i<3;i++){
            if(matrix[i][j]==p.getState()){
                
            }
            else
            {
                ans=false;
                break;
            }
            
            counter+=(matrix[i][j]==-1)?1:0;
            j-=1;
        }
        if(ans)
        return(ans);

        //check columns
        for(int i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(matrix[i][j]==p.getState())
                {

                }
                else{
                    ans=false;
                    break;
                }
                counter+=(matrix[i][j]==-1)?1:0;
            }
            if(ans)
            return(ans);

        }

        //check rows

        for(int k=0;k<3;k++){
            for(j=0;j<3;j++){
                if(matrix[j][k]==p.getState())
                {

                }
                else{
                    ans=false;
                    break;
                }
                counter+=(matrix[k][j]==-1)?1:0;

            }
            if(ans)
            return(ans);
        }


        return false;
    }

    @Override
    public int checkValidity(Set<Integer> s) {
        int row;
        while(true){
            row=generateRandom();
            if(s.contains(row)){
                continue;
            }
            else
                break;
        }
        s.add(row);
        return(row);       
    }



    
}
