package MineSweeper.GameFrame.Stats;

import MineSweeper.GameFrame.Stats.MainButton.MainButton;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class StatsPanel extends JPanel {
    public static MainButton mb = new MainButton();

    public StatsPanel(){
        this.setBackground(Color.lightGray);

        Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        this.setBorder(border);
        this.setVisible(true);

        this.setLayout(new GridBagLayout());

        this.add(mb);

    }

}
