package MineSweeper.Init;

import MineSweeper.GameFrame.Tiles.Location;
import MineSweeper.GameFrame.Tiles.Tile;

import java.util.ArrayList;
import java.util.Random;

public class InitBombs {
    private ArrayList<Tile> bombs = new ArrayList<Tile>();
    public Random rnd = new Random();

    public InitBombs(Tile[][] board, int boardSize, int bombCount){

        for(int i=0; i < bombCount; i++){
            Tile b = randomBomb(board,boardSize);

            while(b.isBomb()){
                b = randomBomb(board,boardSize);
            }

            b.setBomb();
            this.bombs.add(b);

        }
    }

    public ArrayList<Tile> getBombs() {
        return bombs;
    }

    public Tile randomBomb(Tile[][] board, int boardSize){
        Location l = new Location(rnd.nextInt(boardSize), rnd.nextInt(boardSize));
        return board[l.getR()][l.getC()];
    }
}
