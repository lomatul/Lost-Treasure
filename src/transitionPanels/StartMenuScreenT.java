package src.transitionPanels;

import src.DatabaseConnection.PlayerInfo;
import src.buttons.StartScreenButtons;
import src.events.SignUpButtonEvent;
import src.levelObjects.Sound;
import src.levelObjects.StartMenuBackGroundLabels;
import src.levelObjects.StartMenuLabel;
import src.popups.ExitWindowConfirmationDialog;
import src.popups.LoginDialog;
import src.popups.SignupDialog;
import src.popups.UserStatsPopup;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class StartMenuScreenT extends JPanel implements Runnable{
    JFrame jFrame;
    JLabel backGroundImageLabel;
    //Sound bgMusic;
    Sound startMusic;
    Sound clickSound;
    LoadingAnimationT loadingAnimationT;
    JPanel nextScene;

    public StartMenuLabel developedByLabel;
    public StartScreenButtons startGameButton;
    public StartScreenButtons playerStatsButton;
    public StartScreenButtons loginButton;
    public StartScreenButtons signupButton;
    public StartScreenButtons quitButton;
    StartMenuBackGroundLabels gameIcon;
    public StartMenuScreenT(JFrame jFrame){

        this.jFrame = jFrame;
       // bgMusic = new Sound();
        clickSound = new Sound();
        clickSound.setFile("audio/soundeffects/click.wav");
        startMusic= new Sound();
        startMusic.setFile("audio/soundeffects/startmusic.wav");
        startMusic.play();
    }

    private void addBackGroundImageLabel(){
        backGroundImageLabel = createBackgroundLabel("images/StartMenu/startmenubackground.png");
        add(backGroundImageLabel);
    }

    private JLabel createBackgroundLabel(String path){
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0,0,DeviceInformation.screenWidth, DeviceInformation.screenHeight);
        ImageIcon backGroundImage = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(path)));
        backGroundImage.setImage(backGroundImage.getImage().getScaledInstance(DeviceInformation.screenWidth, DeviceInformation.screenHeight, Image.SCALE_SMOOTH));
        backgroundLabel.setIcon(backGroundImage);
        return backgroundLabel;
    }



    public void buildScene(){
        createBackgroundPanel();
        addDevelopedByLabel();
        addQuitButton();
        addLoginButton();
        addStartGameButton();
        addStartGameButtonMouseEvents();
        addSignupButton();
        addPlayerStatsButton();
        addPlayerStatsButtonMouseEvents();
        addGameTitleLabel();
        addGameIconAnimation();
        addBackGroundImageLabel();
        SwingUtilities.invokeLater(() -> gameIcon.startAnimation(5));
        addLoginButtonMouseEvent();

    }

//    private void doButtonThings() {
//        startGameButton.addMouseListener(new MouseListener() {
//            boolean isHovering = false;
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                clickSound.play();
//
////                jFrame.remove(startGameButton.startMenu);
//                jFrame.add(loadingAnimationT);
//
//                bgMusic.stop();
//
//                loadingAnimationT.initializeTimer();
//
//                jFrame.revalidate();
//                jFrame.repaint();
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                startGameButton.setBackground(new Color(100,70,120));
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                startGameButton.setBackground(null);
//                if(isHovering) {
//                    clickSound.play();
//
////                    jFrame.remove(startGameButton.startMenu);
//                    jFrame.add(loadingAnimationT);
//                    loadingAnimationT.initializeTimer();
//
////                    bgMusic.stop();
//
//                    jFrame.revalidate();
//                    jFrame.repaint();
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                isHovering = true;
//                startGameButton.setBackground(new Color(0,40,80));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                isHovering = false;
//                startGameButton.setBackground(null);
//            }
//        });
//    }


    private void addDevelopedByLabel(){
        developedByLabel = new StartMenuLabel();

        developedByLabel.setBounds(DeviceInformation.screenWidth/3, DeviceInformation.screenHeight-35, DeviceInformation.screenWidth*2/3 - 10, 35);
        developedByLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        developedByLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        developedByLabel.setFont(FontInfo.getResizedFont(30f));
        developedByLabel.setText("Developed by: Nawsheen Mehereen, Lomatul Mahzabin, AyeshaAfrozaMohsin");
        developedByLabel.setForeground(Color.lightGray);
        add(developedByLabel);
    }
    private void addLoginButtonMouseEvent(){
        loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickSound.play();
                LoginDialog loginDialog = new LoginDialog(jFrame);
                if(loginDialog.isLoggedIn){
                    loginDialog.addStartMenuSceneT(StartMenuScreenT.this);
                    loginDialog.changeButtons(StartMenuScreenT.this);
                    playerStatsButton.setVisible(true);
                    playerStatsButton.setEnabled(true);
                    startGameButton.setVisible(true);
                    startGameButton.setEnabled(true);
                    repaint();
                    revalidate();
                    repaint();
                    revalidate();
                    jFrame.repaint();
                    jFrame.revalidate();
                }
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

    public void addStartGameButton(){
        clickSound.play();
        startGameButton = new StartScreenButtons(DeviceInformation.screenWidth/4, 70, "Start Game");
        startGameButton.setFont(FontInfo.getResizedFont(60f));
        startGameButton.setBounds(0, DeviceInformation.screenHeight/3, DeviceInformation.screenWidth/5, 70);
        add(startGameButton);
        startGameButton.setVisible(false);
        startGameButton.setEnabled(false);
    }

    public void addPlayerStatsButton(){
        clickSound.play();
        playerStatsButton = new StartScreenButtons(DeviceInformation.screenWidth/4, 70, "Player Statistics");
        playerStatsButton.setFont(FontInfo.getResizedFont(60f));
        playerStatsButton.setBounds(0, DeviceInformation.screenHeight/2, DeviceInformation.screenWidth/5, 70);
        add(playerStatsButton);
        playerStatsButton.setVisible(false);
        playerStatsButton.setEnabled(false);
    }
    public void addLoginButton(){
        clickSound.play();
        loginButton = new StartScreenButtons(DeviceInformation.screenWidth/4, 70, "Sign in");
        loginButton.setBounds(0, DeviceInformation.screenHeight/3, DeviceInformation.screenWidth/5, 70);
        add(loginButton);
    }

    public void addSignupButton(){
        clickSound.play();
        signupButton = new StartScreenButtons(DeviceInformation.screenWidth/4, 70, "Sign up");
        signupButton.setBounds(0, DeviceInformation.screenHeight/2, DeviceInformation.screenWidth/5, 70);
        add(signupButton);
        addSignupButtonMouseEvent();
    }

    private void addSignupButtonMouseEvent(){
        signupButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickSound.play();
                SignupDialog signupDialog = new SignupDialog(jFrame);
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




    public void addQuitButton(){
        clickSound.play();
        quitButton = new StartScreenButtons(DeviceInformation.screenWidth/4, 70, "Quit");
        quitButton.setBounds(0, DeviceInformation.screenHeight*2/3, DeviceInformation.screenWidth/5, 70);
        add(quitButton);
        addQuitButtonMouseEvents();
    }



    private void createBackgroundPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(DeviceInformation.screenWidth, DeviceInformation.screenHeight));
        this.setBackground(Color.decode("#14171C"));
    }

    private void addGameTitleLabel(){
        StartMenuLabel gameTitle = new StartMenuLabel();
        gameTitle.setBounds(DeviceInformation.screenWidth*2/5,DeviceInformation.screenHeight/6, DeviceInformation.screenWidth/2, DeviceInformation.screenHeight/6);
        add(gameTitle);

    }

    @Override
    public void run() {
        buildScene();
    }

    private void addGameIconAnimation(){
        gameIcon = new StartMenuBackGroundLabels("images/StartMenu/startmenuicon.png");
        add(gameIcon);
    }

    private void addQuitButtonMouseEvents(){
        quitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickSound.play();
                new ExitWindowConfirmationDialog(jFrame, new FontInfo());

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

    public void PrepareForSceneTransition(LoadingAnimationT loadingAnimationT, JPanel nextScene) {
        this.loadingAnimationT = loadingAnimationT;
        this.nextScene = nextScene;
    }


    private void addPlayerStatsButtonMouseEvents(){
        playerStatsButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(playerStatsButton.isEnabled()) {
                    clickSound.play();
                    new UserStatsPopup(jFrame);
                }
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
    private void addStartGameButtonMouseEvents(){
        startGameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(startGameButton.isEnabled()){
                    clickSound.play();
                    jFrame.remove(StartMenuScreenT.this);
                    System.out.println("Player Info's game progress in StartMenuT is : " + PlayerInfo.gameProgress);
                    if (PlayerInfo.gameProgress == 0) {
                        loadingAnimationT.changeNextScene(loadingAnimationT.messageFromMomT);
                    } else if (PlayerInfo.gameProgress > 0) {
                        loadingAnimationT.changeNextScene(loadingAnimationT.mapT);
                    }
                    jFrame.add(loadingAnimationT);
                    loadingAnimationT.initializeTimer();
                    jFrame.revalidate();
                    jFrame.repaint();
                }
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
