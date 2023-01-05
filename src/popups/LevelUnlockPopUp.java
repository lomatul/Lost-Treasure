package src.popups;

import src.levelObjects.Sound;
import src.levels.ALevelPanel;
import src.levels.ClassRoomSceneT;
import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;

public class LevelUnlockPopUp extends JDialog {

    JLabel unlockGif;
    JLabel jLabel;
    JButton closeButton;


    public LevelUnlockPopUp (JFrame jFrame, int level_number)
    {

        setModal(true);
        setUndecorated(true);

        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        jLabel = new JLabel();

        jLabel.setPreferredSize(new Dimension(450,75));
        jLabel.setLayout(new FlowLayout());
        jLabel.setForeground(Color.white);
        jLabel.setFont(FontInfo.getResizedFont(30f));
        if(level_number==2){
            jLabel.setText(convertToMultiline("ClassRoom  Unlocked "));
        }
        else if(level_number==3){
            jLabel.setText(convertToMultiline("Library Unlocked "));
        }
        else if (level_number==4){
            jLabel.setText(convertToMultiline("Central Departmental Store  Unlocked "));
        }
        else if (level_number==5){

            jLabel.setText(convertToMultiline("BE AWARE !!! THIS IS THE FINAL LEVEL"));
            jLabel.setFont(FontInfo.getResizedFont(30f));
        }
        repaint();
        revalidate();
        jLabel.setHorizontalTextPosition(JLabel.CENTER);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(550,430);
        setLocationRelativeTo(jFrame);
        setResizable(false);

        closeButton = new JButton();
        closeButton.setBackground(Color.decode("#14171C"));
        closeButton.setPreferredSize(new Dimension(210,40));
        closeButton.setFocusPainted(false);
        closeButton.setHorizontalAlignment(JButton.CENTER);
        closeButton.setBorder(new LineBorder(Color.white,3));
        closeButton.setForeground(Color.white);
        closeButton.setFont(FontInfo.getResizedFont(28f));
        closeButton.setOpaque(true);
        closeButton.setText("Okay");
        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                dispose();
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
        addUnlockGif();
        add(jLabel);
        add(closeButton);
        setVisible(true);
    }

    private void addUnlockGif(){
        unlockGif = new JLabel();
        unlockGif.setPreferredSize(new Dimension(250,250));
        unlockGif.setLayout(null);
        unlockGif.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon animationGifIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Map_images/lockgif.gif")));
        animationGifIcon.setImage(animationGifIcon.getImage().getScaledInstance((int) (animationGifIcon.getIconWidth()*0.625), (int) (animationGifIcon.getIconHeight()*0.625), Image.SCALE_DEFAULT));
        unlockGif.setIcon(animationGifIcon);
        unlockGif.setBackground(null);
        repaint();
        add(unlockGif);
    }
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}

