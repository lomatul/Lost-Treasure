package src.popups;

import src.levelObjects.Sound;
import src.levels.*;
import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelFinishedNotEnoughScore extends JDialog {

    JFrame jFrame;
    ALevelPanel backgoundPanel;
    JLabel textLabel;
    JButton closeButton;
    public Sound objClickSound;
    public Sound GameOverSound;

    public LevelFinishedNotEnoughScore(ALevelPanel jPanel){
        this.backgoundPanel = jPanel;

        setModal(true);
        setUndecorated(true);

        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        textLabel = new JLabel();
        textLabel.setPreferredSize(new Dimension(280,240));
        textLabel.setLayout(new FlowLayout());
        textLabel.setForeground(Color.white);
        textLabel.setText(convertToMultiline("Level Finished but your Score was too low too progress..\nGet "
                + Integer.toString(backgoundPanel.PassingScore) + " points to unlock the Next Level."));

        objClickSound = new Sound();
        objClickSound.setFile("audio/soundeffects/mixkit-mouse-click-close-1113.wav");

        backgoundPanel.backgroundMusic.stop();
        System.gc();

        GameOverSound = new Sound();
        GameOverSound.setFile("audio/soundeffects/failbg.wav");

        GameOverSound.play();

        textLabel.setFont(FontInfo.getResizedFont(32f));
        add(textLabel);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(300,320);
        setLocationRelativeTo(backgoundPanel);
        setResizable(false);
        closeButton = new JButton();
        closeButton.setBackground(Color.decode("#14171C"));
        closeButton.setPreferredSize(new Dimension(180,40));
        closeButton.setFocusPainted(false);
        closeButton.setHorizontalAlignment(JButton.CENTER);
        closeButton.setBorder(new LineBorder(Color.white,2));
        closeButton.setForeground(Color.white);
        closeButton.setFont(FontInfo.getResizedFont(25f));
        closeButton.setOpaque(true);
        closeButton.setText("Exit to Menu");
        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                objClickSound.play();
                backgoundPanel.timerLabel.endLevel();
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

        add(closeButton);

        setVisible(true);
//        jFrame.add(this);
    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}