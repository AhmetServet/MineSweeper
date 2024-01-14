package MineSweeper.GameFrame.Tiles;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class TilePanel extends JPanel {
    public TilePanel(Tile[][] board, int boardSize){
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(boardSize *32, (boardSize +1)*32));
        this.setLayout(new GridLayout(boardSize, boardSize));
        this.setVisible(true);

        Border outBorder = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.setBorder(outBorder);

        for(int i = 0; i< boardSize; i++){
            for(int j = 0; j< boardSize; j++) {
                this.add(board[i][j]);
            }
        }
    }
}
