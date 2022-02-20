package model;

public class Ladder {
    int ladderhead=-1;
    int laddertail=-1;

    public Ladder(int head,int tail){
        ladderhead=head;
        laddertail=tail;
    }

    public int getLadderhead() {
        return ladderhead;
    }

    public void setLadderhead(int ladderhead) {
        this.ladderhead = ladderhead;
    }

    public int getLaddertail() {
        return laddertail;
    }

    public void setLaddertail(int laddertail) {
        this.laddertail = laddertail;
    }
    
}
