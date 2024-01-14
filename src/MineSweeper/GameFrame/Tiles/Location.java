package MineSweeper.GameFrame.Tiles;


public class Location {
    private int r;
    private int c;

    public Location(int r, int c){
        this.r = r;
        this.c = c;
    }
    public void setR(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }
}
