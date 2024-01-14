package MineSweeper.GameFrame.Stats.MainButton;

import MineSweeper.Controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;


public class MainButton extends JButton {
    public Controller controller;
    private static final Image _happyFace;
    private static final Image _deadFace;
    private static final Image _coolFace;

    static {
        try {
            _deadFace = ImageIO.read(Objects.requireNonNull(MainButton.class.getResource("resources/deadFace.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            _happyFace = ImageIO.read(Objects.requireNonNull(MainButton.class.getResource("resources/happyFace.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            _coolFace = ImageIO.read(Objects.requireNonNull(MainButton.class.getResource("resources/coolFace.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static Image happyFace = _happyFace.getScaledInstance( 48, 48,  java.awt.Image.SCALE_SMOOTH );
    public static Image deadFace = _deadFace.getScaledInstance( 48, 48,  java.awt.Image.SCALE_SMOOTH );
    public static Image coolFace = _coolFace.getScaledInstance(48,48, java.awt.Image.SCALE_SMOOTH );

    public MainButton(){
        super();
        this.setPreferredSize(new Dimension(64,64));
        this.setIcon(new ImageIcon(happyFace));
        this.setBackground(Color.gray);

        Border border  = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        this.setBorder(border);

        this.setVisible(true);


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Controller();
                Controller.changeFlaggedBombCount(-Controller.getFlaggedBombCount());
                setIcon(new ImageIcon(happyFace));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
