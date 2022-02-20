package model;

public class Snake {
    int snakehead=-1;
    int snaketail=-1;
    public Snake(int head,int tail){
        snakehead=head;
        snaketail=tail;
    }
    public int getSnakehead() {
        return snakehead;
    }
    public void setSnakehead(int snakehead) {
        this.snakehead = snakehead;
    }
    public int getSnaketail() {
        return snaketail;
    }
    public void setSnaketail(int snaketail) {
        this.snaketail = snaketail;
    }
}
