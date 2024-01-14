package MineSweeper.Init;

import MineSweeper.GameFrame.Tiles.Location;
import MineSweeper.GameFrame.Tiles.Tile;

public class InitBoard {
    private final Tile[][] board;

    public InitBoard(int boardSize){
        board = new Tile[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++) {
                Tile tile = new Tile(new Location(i,j));
                board[i][j] = tile;
            }
        }
    }



    public void setBoard(int r, int c, int val) {
        this.board[r][c].setNumber(val);
    }

    public Tile[][] getBoard() {
        return board;
    }
}

