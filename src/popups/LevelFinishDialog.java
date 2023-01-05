package src.popups;

import src.levelObjects.Sound;
import src.levels.*;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class LevelFinishDialog extends JDialog {

    JLabel jLabel;

    JLabel congratulationsgif;
    JButton exitToMapButton;
    Sound levelCompleted;


    JButton closeButton2;

    public LevelFinishDialog(JFrame jFrame,int level_number, JPanel jPanel){
        levelCompleted = new Sound();
        levelCompleted.setFile("audio/soundeffects/lvlcompleted.wav");
        levelCompleted.play();

        Sound sound = new Sound();
        sound.setSoundEffectFile("levelFinishTada");
        sound.play();


        setModal(true);
        setUndecorated(true);

        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(DeviceInformation.screenWidth/5,200));
        jLabel.setLayout(new FlowLayout());
        jLabel.setForeground(Color.white);
//        jLabel.setText(convertToMultiline("Congratulations!\nYou've cleared this level successfully!"));
        Integer score=0;
        JTextPane scoreTextPane = new JTextPane();
        JTextPane levelCompletedTextPane = new JTextPane();
        JTextPane timeTakenTextPane = new JTextPane();
        levelCompletedTextPane.setFont(FontInfo.getResizedFont(70f));
        if (level_number==6){
            jLabel.setText(convertToMultiline("GAME FINISHED"));
        }
        else
        {
            levelCompletedTextPane.setText("Level completed!");
        }
        levelCompletedTextPane.setBackground(Color.decode("#14171C"));
        levelCompletedTextPane.setForeground(Color.white);
        levelCompletedTextPane.setFocusable(false);
        jLabel.add(levelCompletedTextPane);
        jLabel.repaint();
        jLabel.revalidate();
        if(jPanel instanceof ALevelPanel){

            score = ((ALevelPanel)jPanel).scoreBoard.score;
            scoreTextPane.setText("Score: " + score+"   ");
            scoreTextPane.setBackground(Color.decode("#14171C"));
            scoreTextPane.setForeground(Color.white);
            scoreTextPane.setFocusable(false);
            scoreTextPane.setFont(FontInfo.getResizedFont(40f));
            jLabel.add(scoreTextPane);
            jLabel.repaint();
            jLabel.revalidate();

            timeTakenTextPane.setText("Time: " + ((ALevelPanel)jPanel).timerLabel.elapsedTime);
            timeTakenTextPane.setBackground(Color.decode("#14171C"));
            timeTakenTextPane.setForeground(Color.white);
            timeTakenTextPane.setFocusable(false);
            timeTakenTextPane.setFont(FontInfo.getResizedFont(40f));
            jLabel.add(timeTakenTextPane);
            jLabel.repaint();
            jLabel.revalidate();


        }
        jLabel.setFont(FontInfo.getResizedFont(65f));
        add(jLabel);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        setSize(DeviceInformation.screenWidth/5,300);
        setLocationRelativeTo(jFrame);
        setResizable(false);
        exitToMapButton = new JButton();
        exitToMapButton.setBackground(Color.decode("#14171C"));
        exitToMapButton.setPreferredSize(new Dimension(110,50));
        exitToMapButton.setFocusPainted(false);
        exitToMapButton.setHorizontalAlignment(JButton.CENTER);
        exitToMapButton.setBorder(new LineBorder(Color.white,2));
        exitToMapButton.setForeground(Color.white);
        exitToMapButton.setFont(FontInfo.getResizedFont(25f));
        exitToMapButton.setOpaque(true);
        exitToMapButton.setText("Exit to Map!");
        exitToMapButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(jPanel instanceof ALevelPanel) {
                    ((ALevelPanel) jPanel).timerLabel.endLevel();
                    Sound alert = new Sound();
                    alert.setFile("audio/soundeffects/alert.wav");
                    alert.play();

                    dispose();
                }
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
        add(exitToMapButton);

        setVisible(true);
//        jFrame.add(this);
    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public void createCongratulationsgif(){
        congratulationsgif = new JLabel();
        congratulationsgif.setSize(100,100);
        ImageIcon gif = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/congratulations/friendsClappingGif.gif")));
        gif.setImage(gif.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        congratulationsgif.setIcon(gif);
        congratulationsgif.setVisible(true);
        add(congratulationsgif);
    }
}
