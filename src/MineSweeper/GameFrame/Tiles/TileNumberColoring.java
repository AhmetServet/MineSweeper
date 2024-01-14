package MineSweeper.GameFrame.Tiles;

import javax.swing.*;
import java.awt.*;

public class TileNumberColoring {
    private final JLabel lbl = new JLabel();

    public TileNumberColoring(int number) {
        lbl.setText(String.valueOf(number));
        Font font = new Font("Courier", Font.BOLD, 18);
        lbl.setFont(font);
        switch (number){
            case 1:
                lbl.setForeground(new Color(0,0,250));
                break;
            case 2:
                lbl.setForeground(new Color(0,127,0));
                break;
            case 3:
                lbl.setForeground(new Color(200,0,0));
                break;
            case 4:
                lbl.setForeground(new Color(8,8,136));
                break;
            case 5:
                lbl.setForeground(new Color(132,0,0));
                break;
        }
    }

    public JLabel getLbl() {
        return lbl;
    }
}
