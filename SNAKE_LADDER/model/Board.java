package model;

import java.util.HashMap;
import java.util.Map;

public class Board
{
    int size;
    int mat[][];
    Map<Integer,int[]>mapper=new HashMap<Integer,int[]>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public Map<Integer, int[]> getMapper() {
        return mapper;
    }

    public void setMapper(Map<Integer, int[]> mapper) {
        this.mapper = mapper;
    }

    public Board(){
        size=10;
        mat=new int[size][size];
        int number=0;
        boolean flag=true;
        for(int i=0;i<size;i++){
            if(flag){
                for(int j=0;j<size;j++){
                    mat[i][j]=number;
                    mapper.put(number, new int[]{i,j});
                    number+=1;
                }
                flag=false;

            }
            else{
                for(int j=size-1;j>=0;j--){
                    mat[i][j]=number;
                    mapper.put(number, new int[]{i,j});
                    number+=1;
                }
                flag=true;
            }
            
        }

    }

}