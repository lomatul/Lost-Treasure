package src.popups;

import src.levelObjects.Sound;
import src.levels.*;
import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TimeOverConfirmationDialog extends JDialog {

    JFrame jFrame;
    ALevelPanel backgoundPanel;
    JLabel textLabel;
    JButton closeButton;
    public Sound objClickSound;
    public Sound GameOverSound;

    public TimeOverConfirmationDialog(JFrame jFrame, ALevelPanel jPanel){
        this.jFrame = jFrame;
        this.backgoundPanel = jPanel;

        System.out.println("entered timer");
        if(backgoundPanel.hintConfirmationDialogue != null){
            System.out.println("tried offing the hind animation");
            backgoundPanel.hintConfirmationDialogue.dispose();
        }

        setModal(true);
        setUndecorated(true);

        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        textLabel = new JLabel();
        textLabel.setPreferredSize(new Dimension(280,90));
        textLabel.setLayout(new FlowLayout());
        textLabel.setForeground(Color.white);
        textLabel.setText(convertToMultiline("Oh no! Your Time is Up"));

        objClickSound = new Sound();
        objClickSound.setFile("audio/soundeffects/mixkit-mouse-click-close-1113.wav");
      //  objClickSound.play();
        backgoundPanel.backgroundMusic.stop();
        System.gc();

        GameOverSound = new Sound();
        GameOverSound.setFile("audio/soundeffects/failbg.wav");

        System.out.println("Omae wa mou shin desu");
        GameOverSound.play();

        textLabel.setFont(FontInfo.getResizedFont(28f));
        add(textLabel);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(300,150);
        setLocationRelativeTo(jFrame);
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
                objClickSound.play();
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
//                GameOverSound.stop();
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
