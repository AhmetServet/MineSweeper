package MineSweeper.Init;

import MineSweeper.GameFrame.Tiles.Location;
import MineSweeper.GameFrame.Tiles.Tile;

import java.util.ArrayList;

public class InitTileNumbers {
    public InitTileNumbers(Tile[][] board, int boardSize, ArrayList<Tile> bombs){
        for (Tile bomb : bombs) {
            Location l = bomb.getLocation_();

            int r = l.getR();
            int c = l.getC();

            for(int i = r-1;i <= r+1;i++){
                for(int j = c-1;j <= c+1;j++){
                    if(i >= 0 && j >= 0 && i < boardSize && j < boardSize && !board[i][j].isBomb()){
                        board[i][j].increaseNumber();
                    }
                }
            }

        }
    }


}