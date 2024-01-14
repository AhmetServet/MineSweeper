package MineSweeper.Controller;
import MineSweeper.GameFrame.GameFrame;
import MineSweeper.GameFrame.Stats.MainButton.MainButton;
import MineSweeper.GameFrame.Stats.StatsPanel;
import MineSweeper.GameFrame.Tiles.Location;
import MineSweeper.GameFrame.Tiles.Tile;
import MineSweeper.Init.InitBoard;
import MineSweeper.Init.InitBombs;
import MineSweeper.Init.InitTileNumbers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Controller {
    private static int boardSize = 9;
    private static int bombCount = 10;
    private static int flaggedBombCount = 0;

    public static Tile[][] board;
    private static ArrayList<Tile> bombs;

    private InitBoard initBoard;
    private InitBombs initBombs;
    private InitTileNumbers initTileNumbers;

    private static boolean cheatMode = false;

    public Controller(){
        for (int i = 0; i < Frame.getFrames().length; i++) {
            Frame.getFrames()[i].dispose();
        }
        initAll();
        new GameFrame(board, boardSize);
    }

    public Controller(int boardSize, int bombCount){
        for (int i = 0; i < Frame.getFrames().length; i++) {
            Frame.getFrames()[i].dispose();
        }

        Controller.boardSize = boardSize;
        Controller.bombCount = bombCount;

        initAll();

        new GameFrame(board, boardSize);
    }

    public void initAll(){
        initBoard = new InitBoard(boardSize);
        board = initBoard.getBoard();

        initBombs = new InitBombs(board, boardSize, bombCount);
        bombs = initBombs.getBombs();

        initTileNumbers = new InitTileNumbers(board, boardSize, bombs);
    }

    public static void loose(){
        bombs.forEach((b) -> {
            Location l = b.getLocation_();
            board[l.getR()][l.getC()].add(new JLabel("\uD83D\uDCA3"),3,0);
        });

        for(int i=0;i<boardSize; i++){
            for(int j=0;j<boardSize;j++){
                board[i][j].setClickable(false);
            }
        }

        StatsPanel.mb.setIcon(new ImageIcon(MainButton.deadFace));

    }


    public static void win(){
        if(flaggedBombCount == bombCount){
            for(int i=0;i<boardSize; i++){
                for(int j=0;j<boardSize;j++){
                    board[i][j].setClickable(false);
                }
            }

            StatsPanel.mb.setIcon(new ImageIcon(MainButton.coolFace));
        }
    }
    public static void findAdjacentTiles(int r, int c) {
        for (int i = r - 4; i <= r + 4; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && j >= 0 && i < boardSize && j < boardSize && !board[i][j].isExposed() && !board[i][j].isBomb()) {
                        board[i][j].expose();
                }
            }
        }

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 4; j <= c + 4; j++) {
                if (i >= 0 && j >= 0 && i < boardSize && j < boardSize && !board[i][j].isExposed() && !board[i][j].isBomb()) {
                        board[i][j].expose();
                }
            }
        }

        for (int i = r - 3; i <= r + 3; i++) {
            for (int j = c - 3; j <= c + 3; j++) {
                if (i >= 0 && j >= 0 && i < boardSize && j < boardSize && !board[i][j].isExposed() && !board[i][j].isBomb()) {
                    board[i][j].expose();
                }
            }
        }

    }


    public static void changeFlaggedBombCount(int count) {
        flaggedBombCount += count;
    }

    public static int getFlaggedBombCount() {
        return flaggedBombCount;
    }

    public static void changeCheatMode() {
        cheatMode = !cheatMode;
    }

    public static boolean getCheatMode(){
        return cheatMode;
    }
}
