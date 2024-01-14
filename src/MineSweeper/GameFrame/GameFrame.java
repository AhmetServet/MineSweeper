package MineSweeper.GameFrame;

import MineSweeper.GameFrame.Stats.StatsPanel;
import MineSweeper.GameFrame.Tiles.Tile;
import MineSweeper.GameFrame.Tiles.TilePanel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    public static JPanel sp;
    public static JPanel tp;
    public GameFrame (Tile[][] board, int boardSize) {
        this.setTitle("Mine Sweeper");
        this.setPreferredSize(new Dimension((boardSize +2)*32,(boardSize +5)*32));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        this.setLocation(width/3, height/5);


        JMenuBar gameMenu = new GameMenu();
        this.setJMenuBar(gameMenu);

        this.getContentPane().setLayout(new BorderLayout());

        sp = new StatsPanel();
        this.getContentPane().add(sp, BorderLayout.CENTER);

        tp = new TilePanel(board, boardSize);
        this.getContentPane().add(tp, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);

    }
}
