package MineSweeper.GameFrame.Tiles;

import MineSweeper.Controller.Controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static MineSweeper.Controller.Controller.getCheatMode;
import static MineSweeper.Controller.Controller.loose;

public class Tile extends JPanel{
    private final Location location;
    private boolean isBomb;
    private int number = 0;
    private boolean isExposed;
    private boolean isFlagged;
    private boolean isClickable = true;

    private final JLabel flagLabel = new JLabel("🚩");
    private final JLabel bombLabel = new JLabel("💣");
    private JLabel lbl;


    public Tile(Location location){
        this.location = location;
        this.setNumber(0);
        isExposed = false;
        this.unflag();
        this.isBomb = false;

        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        this.setBorder(border);


        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(32,32));
        this.setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isClickable) {
                    if (!isExposed && e.getButton() == MouseEvent.BUTTON1) {
                        expose();
                        if(isBlank()){
                            Controller.findAdjacentTiles(location.getR(),location.getC());
                        }
                    }
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        if (!isExposed) {
                            if (!isFlagged) {
                                flag();
                                Controller.win();
                            }
                            else
                                unflag();
                        }
                    }
                    repaint();
                    revalidate();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(getCheatMode() && !isExposed())
                    showUnderneath();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(getCheatMode() && !isExposed())
                    resetTile();
            }
        });
    }

    public void setBomb() {
        isBomb = true;
        number = -1;
    }

    public Location getLocation_(){
        return location;
    }

    public void flag() {
        isFlagged = true;
        if(this.isBomb)
            Controller.changeFlaggedBombCount(1);
        flagLabel.setVisible(true);
        this.add(flagLabel, 2,0);

    }

    public void unflag() {
        isFlagged = false;
        if(this.isBomb)
            Controller.changeFlaggedBombCount(-1);
        flagLabel.setVisible(false);
    }

    public boolean isBlank() {
        return number == 0;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void expose() {
        if(!isFlagged) {
            isExposed = true;
            if(getNumber() == -1) {
                lbl = bombLabel;
                loose();

            }
            else if(isBlank())
                lbl = new JLabel("");
            else
                lbl = new TileNumberColoring(number).getLbl();

            this.add(lbl, 1,0);
            this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }

    }

    public void showUnderneath(){
        if(this.isBomb){
            lbl = bombLabel;
        } else {
            lbl = new TileNumberColoring(number).getLbl();
        }
        this.add(lbl, 1,0);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    public void resetTile(){
            this.remove(lbl);
            Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            this.setBorder(border);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void increaseNumber(){
        this.number+=1;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }
}

