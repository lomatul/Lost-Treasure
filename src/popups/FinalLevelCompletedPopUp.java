package src.popups;

import src.DatabaseConnection.OracleDatabase;
import src.DatabaseConnection.PlayerInfo;
import src.levelObjects.Sound;
import src.levels.DormVersion2;
import src.setup.FontInfo;
import src.transitionPanels.LoadingAnimationT;
import src.transitionPanels.MapT;
import src.transitionPanels.MessageFromMomT;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class FinalLevelCompletedPopUp extends JDialog {
    JFrame jFrame;
    DormVersion2 dormVersion2;
    JLabel animationGifLabel;
    JButton closeButton;
    JButton restartGameButton;
    JLabel congratulationsLabel;
    JLabel completedGameLabel;
    LoadingAnimationT loadingAnimationT;
    JLabel resetPlayerInfoLabel;

    public FinalLevelCompletedPopUp(JFrame jFrame, int level_number, DormVersion2 dormVersion2)
    {
        Sound sound = new Sound();
        sound.setSoundEffectFile("levelFinishTada");
        sound.play();
        
        this.jFrame = jFrame;
        this.loadingAnimationT = dormVersion2.loadingAnimationT;
        this.dormVersion2 = dormVersion2;
        setModal(true);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        addAnimationGifLabel();
        addCongratulationsLabel();
        addCompletedGameLevel();
        setSize(700,510);
        setLocationRelativeTo(jFrame);
        setResizable(false);
        addRestartGameButton();
        addQuitButton();
        addResetPlayerInfoLabel();
        setVisible(true);
    }

    private void addAnimationGifLabel(){
        animationGifLabel = new JLabel();
        animationGifLabel.setPreferredSize(new Dimension(300,300));
        animationGifLabel.setLayout(null);
        animationGifLabel.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon animationGifIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/finishedgameanimationv3.gif")));
        animationGifIcon.setImage(animationGifIcon.getImage().getScaledInstance((int) (animationGifIcon.getIconWidth()*0.625), (int) (animationGifIcon.getIconHeight()*0.625), Image.SCALE_DEFAULT));
        animationGifLabel.setIcon(animationGifIcon);
        animationGifLabel.setBackground(null);
        repaint();
        add(animationGifLabel);
    }

    private void addResetPlayerInfoLabel(){
        resetPlayerInfoLabel = new JLabel();
        resetPlayerInfoLabel.setPreferredSize(new Dimension(600,30));
        resetPlayerInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        resetPlayerInfoLabel.setBackground(Color.decode("#14171C"));
        resetPlayerInfoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        resetPlayerInfoLabel.setFont(FontInfo.getResizedFont(25f));
        resetPlayerInfoLabel.setForeground(Color.pink);
        resetPlayerInfoLabel.setText("Player statistics have been reset!");
        resetPlayerInfoLabel.setVisible(false);
        repaint();
        add(resetPlayerInfoLabel);
    }


    private void addQuitButton() {
        closeButton = new JButton();
        closeButton.setBackground(Color.decode("#14171C"));
        closeButton.setPreferredSize(new Dimension(210,40));
        closeButton.setFocusPainted(false);
        closeButton.setHorizontalAlignment(JButton.CENTER);
        closeButton.setBorder(new LineBorder(Color.white,3));
        closeButton.setForeground(Color.white);
        closeButton.setFont(FontInfo.getResizedFont(28f));
        closeButton.setOpaque(true);
        closeButton.setFocusPainted(false);
        closeButton.setText("Exit Game");
        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
//                if(backgroundPanel instanceof MessageFromMomT){
//                    loadingAnimationT = ((MessageFromMomT) backgroundPanel).loadingAnimationT;
//                } else if (backgroundPanel instanceof MapT) {
//                    loadingAnimationT = ((MapT) backgroundPanel).loadingAnimationT;
//                    ((MapT) backgroundPanel).mapMusic.stop();
//                }else{
//                    System.out.println("idk what you sent but its not message from mom or map");
//                }

//                jFrame.remove(dormVersion2);
//                repaint();
//                revalidate();
//                loadingAnimationT.changeNextScene(dormVersion2.loadingAnimationT.startMenuScreenT);
//                jFrame.add(loadingAnimationT);
//                loadingAnimationT.initializeTimer();

                dispose();
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
                closeButton.setForeground(Color.decode("#14171C"));
                closeButton.setBackground(Color.white);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                dispose();
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
                closeButton.setForeground(Color.decode("#14171C"));
                closeButton.setBackground(Color.white);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                repaint();
                closeButton.setBackground(Color.decode("#14171C"));
                closeButton.setForeground(Color.white);
                repaint();
            }
        });
        add(closeButton);
    }
    private void addRestartGameButton() {
        restartGameButton = new JButton();
        restartGameButton.setBackground(Color.decode("#14171C"));
        restartGameButton.setPreferredSize(new Dimension(210,40));
        restartGameButton.setFocusPainted(false);
        restartGameButton.setHorizontalAlignment(JButton.CENTER);
        restartGameButton.setBorder(new LineBorder(Color.white,3));
        restartGameButton.setForeground(Color.white);
        restartGameButton.setFont(FontInfo.getResizedFont(28f));
        restartGameButton.setOpaque(true);
        restartGameButton.setFocusPainted(false);
        restartGameButton.setText("Reset Progress");
        restartGameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                PlayerInfo.gameProgress = 0;
                resetPlayerStats();
                OracleDatabase.resetPlayerInfo();
                resetPlayerInfoLabel.setVisible(true);
                repaint();

//                System.out.println("its supposed to go man");
//
//                loadingAnimationT.changeNextScene(loadingAnimationT.startMenuScreenT);
//                jFrame.remove(dormVersion2);
//                jFrame.add(loadingAnimationT);
//                loadingAnimationT.initializeTimer();
//                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
                restartGameButton.setForeground(Color.decode("#14171C"));
                restartGameButton.setBackground(Color.white);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                PlayerInfo.gameProgress = 0;
                resetPlayerStats();
                repaint();
                OracleDatabase.resetPlayerInfo();
                resetPlayerInfoLabel.setVisible(true);
//                System.exit(0);
                System.out.println("its supposed to go man");

//                loadingAnimationT.changeNextScene(loadingAnimationT.startMenuScreenT);
//                jFrame.remove(dormVersion2);
//                jFrame.add(loadingAnimationT);
//                loadingAnimationT.initializeTimer();
//                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
                restartGameButton.setForeground(Color.decode("#14171C"));
                restartGameButton.setBackground(Color.white);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                repaint();
                restartGameButton.setBackground(Color.decode("#14171C"));
                restartGameButton.setForeground(Color.white);
                repaint();
            }
        });
        add(restartGameButton);
    }

    private void addCongratulationsLabel() {
        congratulationsLabel = new JLabel();
        congratulationsLabel.setPreferredSize(new Dimension(600,50));
        congratulationsLabel.setLayout(new FlowLayout());
        congratulationsLabel.setForeground(Color.white);
        congratulationsLabel.setText("Congratulations!");
        congratulationsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        congratulationsLabel.setFont(FontInfo.getResizedFont(43f));
        congratulationsLabel.setHorizontalTextPosition(JLabel.CENTER);
        add(congratulationsLabel);
    }
        private void addCompletedGameLevel() {
        completedGameLabel = new JLabel();
        completedGameLabel.setPreferredSize(new Dimension(600,50));
        completedGameLabel.setLayout(new FlowLayout());
        completedGameLabel.setForeground(Color.white);
        completedGameLabel.setText("You've completed the game!");
        completedGameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        completedGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        completedGameLabel.setFont(FontInfo.getResizedFont(43f));
        completedGameLabel.setHorizontalTextPosition(JLabel.CENTER);
        add(completedGameLabel);
    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }


    private void resetPlayerStats(){
        PlayerInfo.hasStartedGame = false;
        PlayerInfo.DormHighScore = -1;
        PlayerInfo.DormLeastTime = -1;

        PlayerInfo.ClassroomHighScore = -1;
        PlayerInfo.ClassroomLeastTime = -1;

        PlayerInfo.LibraryHighScore = -1;
        PlayerInfo.LibraryLeastTime = -1;

        PlayerInfo.CDSHighScore = -1;
        PlayerInfo.CDSLeastTime = -1;

        PlayerInfo.DormV2HighScore = -1;
        PlayerInfo.DormV2LeastTime = -1;

        PlayerInfo.numberOfFinished = 0;
    }
}

