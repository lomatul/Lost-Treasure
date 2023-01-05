package src.popups;

import src.levelObjects.Sound;
import src.levels.ALevelPanel;
import src.setup.FontInfo;
import src.transitionPanels.LoadingAnimationT;
import src.transitionPanels.MapT;
import src.transitionPanels.MessageFromMomT;
import src.transitionPanels.StartMenuScreenT;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BackToMenuDialogue extends JDialog {

    JLabel jLabel;
    JButton closeButton;
    JPanel backgroundPanel;
    JButton closeButton2;

    public BackToMenuDialogue(JFrame jFrame, JPanel backgroundPanel){
        this.backgroundPanel = backgroundPanel;
        setModal(true);
        setUndecorated(true);

        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(300,230));
        jLabel.setLayout(new FlowLayout());
        jLabel.setForeground(Color.white);
        jLabel.setText(convertToMultiline("Do you want to go back to Start Menu?"));

        jLabel.setFont(FontInfo.getResizedFont(35f));
        add(jLabel);
        jLabel.setHorizontalTextPosition(JLabel.CENTER);
        setSize(330,320);
        setLocationRelativeTo(jFrame);
        setResizable(false);
        closeButton = new JButton();
        closeButton.setBackground(Color.decode("#14171C"));
        closeButton.setPreferredSize(new Dimension(120,50));
        closeButton.setFocusPainted(false);
        closeButton.setHorizontalAlignment(JButton.CENTER);
        closeButton.setBorder(new LineBorder(Color.white,2));
        closeButton.setForeground(Color.white);
        closeButton.setFont(FontInfo.getResizedFont(27f));
        closeButton.setOpaque(true);
        closeButton.setText("Yes");

        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Sound clicksound= new Sound();
                clicksound.setFile("audio/soundeffects/click.wav");
                clicksound.play();

                LoadingAnimationT loadingAnimationT = null;

                if(backgroundPanel instanceof MessageFromMomT){
                    loadingAnimationT = ((MessageFromMomT) backgroundPanel).loadingAnimationT;
                } else if (backgroundPanel instanceof MapT) {
                    loadingAnimationT = ((MapT) backgroundPanel).loadingAnimationT;
                    ((MapT) backgroundPanel).mapMusic.stop();
                }else{
                    System.out.println("idk what you sent but its not message from mom or map");
                }

                jFrame.remove(backgroundPanel);
                loadingAnimationT.changeNextScene(loadingAnimationT.startMenuScreenT);

                jFrame.add(loadingAnimationT);
                loadingAnimationT.initializeTimer();

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





        closeButton2 = new JButton();
        closeButton2.setFont(FontInfo.getResizedFont(27f));
        closeButton2.setBackground(Color.decode("#14171C"));
        closeButton2.setPreferredSize(new Dimension(120,50));
        closeButton2.setFocusPainted(false);
        closeButton2.setHorizontalAlignment(JButton.CENTER);
        closeButton2.setBorder(new LineBorder(Color.white,2));
        closeButton2.setForeground(Color.white);
        closeButton2.setOpaque(true);
        closeButton2.setText("No");
        closeButton2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound clicksound= new Sound();
                clicksound.setFile("audio/soundeffects/click.wav");
                clicksound.play();
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
        add(closeButton2);
        setVisible(true);

    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}