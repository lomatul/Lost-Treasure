package src.transitionPanels;

import src.DatabaseConnection.PlayerInfo;
import src.buttons.CloseButton;
import src.levelObjects.Sound;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;

public class MessageFromMomT extends JPanel implements Runnable {

    JFrame jFrame;
    Font eastSea = FontInfo.getResizedFont(50f);
    JLabel backgroundLabel;
    JLabel Bubble1;
    JLabel Bubble2;
    JLabel Text1;
    public Sound objClickSound;
    JLabel Text2;
    public LoadingAnimationT loadingAnimationT;
    public JPanel nextScene;
    int taps = 0;



    public  MessageFromMomT(JFrame jFrame){
        this.jFrame = jFrame;
        this.setLayout(null);
    }
    public void addCustomWindowCloseButton(){
        CloseButton closeButton = new CloseButton("X",jFrame, this);
        this.add(closeButton);
    }

    public void buildScene() throws IOException{
        createText1();
        createText2();
        createBubble1();
        createBubble2();

        objClickSound = new Sound();
        objClickSound.setFile("audio/soundeffects/unlock.wav");

        addCustomWindowCloseButton();
        addTapToContinue();
        addListener();
        createBackground("images/PhoneScreenImages/PhoneScreen.png");
        this.repaint();
        this.repaint();
    }


    private void createBubble1() {
        Bubble1 = new JLabel();
        Bubble1.setLayout(null);
        Bubble1.setBounds(0,0, DeviceInformation.screenWidth, DeviceInformation.screenHeight);
        Bubble1.setVisible(false);
        ImageIcon  bubbleIcon= new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/PhoneScreenImages/LeftSpeechBubble.png")));
        Image image1 = bubbleIcon.getImage();
        image1 = image1.getScaledInstance(DeviceInformation.screenWidth, DeviceInformation.screenHeight, Image.SCALE_DEFAULT);
        ImageIcon bubbleIconScaled = new ImageIcon(image1);

        Bubble1.setIcon(bubbleIconScaled);
        add(Bubble1);

    }
    private void createBubble2() {
        Bubble2 = new JLabel();
        Bubble2.setLayout(null);
        Bubble2.setBounds(0,0, DeviceInformation.screenWidth, DeviceInformation.screenHeight);
        Bubble2.setVisible(false);
        ImageIcon  bubbleIcon= new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/PhoneScreenImages/TwoSpeechBubbles.png")));
        Image image1 = bubbleIcon.getImage();
        image1 = image1.getScaledInstance(DeviceInformation.screenWidth, DeviceInformation.screenHeight, Image.SCALE_DEFAULT);
        ImageIcon bubbleIconScaled = new ImageIcon(image1);
        Bubble2.setIcon(bubbleIconScaled);
        add(Bubble2);
    }

    private void createText1(){
        Text1 = new JLabel(
                "<html>Assalamualaikum Dear<br/>Did you reach safely?<br/>Hope your classes are going well.</html>",
                SwingConstants.CENTER);
//        Text1.setBackground(Color.pink);
        Text1.setLayout(null);
        Text1.setBounds(DeviceInformation.screenWidth*470/1920, DeviceInformation.screenHeight*128/1080, 520, 277);
        Text1.setBackground(Color.BLACK);



        Text1.setForeground(Color.decode("#14171C"));
        Text1.setFont(eastSea);
//        Text1.setOpaque(true);
        Text1.setVisible(false);
        this.add(Text1);

        revalidate();
        repaint();
    }
    private void createText2(){
        Text2 = new JLabel(
                "<html>Oh I forgot to mention<br/>I packed a special present for you in your bag<br/>Tell me if you like it.</html>",
                SwingConstants.CENTER);
        Text2.setLayout(null);
        Text2.setBounds(DeviceInformation.screenWidth*1300/1920, DeviceInformation.screenHeight*50/1080, 520, 300);
        Text2.setBackground(Color.BLACK);
        Text2.setForeground(Color.decode("#14171C"));
        Text2.setFont(eastSea);
//        Text2.setOpaque(true);
        Text2.setVisible(false);
        this.add(Text2);

        revalidate();
        repaint();
    }

    public void PrepareForSceneTransition(LoadingAnimationT loadingAnimationT, JPanel nextScene) {
        this.loadingAnimationT = loadingAnimationT;
        this.nextScene = nextScene;
    }
    public void EndScene(){
        jFrame.remove(this);
        loadingAnimationT.changeNextScene(nextScene); //to map
        jFrame.add(loadingAnimationT);
        loadingAnimationT.initializeTimer();

        jFrame.revalidate();
        jFrame.repaint();
    }

    private void addListener() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                taps++;
                if(taps == 1 ){
                    Bubble1.setVisible(true);
                    Text1.setVisible(true);

                    objClickSound.play();
                    repaint();
                    revalidate();
                }else if(taps == 2){
                    Bubble1.setVisible(false);
                    Bubble2.setVisible(true);
                    objClickSound.play();
                    Text2.setVisible(true);
                    repaint();
                    revalidate();
                }else {
                    if(PlayerInfo.gameProgress <= 0){
                        PlayerInfo.gameProgress = 1;
                    }
                    EndScene();
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

    private void addTapToContinue() {
        JLabel TapToContinue = new JLabel("Tap to Continue", SwingConstants.CENTER);
        TapToContinue.setLayout(null);
        TapToContinue.setBounds((DeviceInformation.screenWidth /2) - 150, DeviceInformation.screenHeight -50, 300, 50);
        TapToContinue.setBackground(Color.BLACK);
        TapToContinue.setForeground(Color.decode("#14171C"));
        TapToContinue.setFont(eastSea);
        this.add(TapToContinue);
        revalidate();
        repaint();
    }

    public void createBackground(String pictureLocation) {
        this.setBounds(0, 0, DeviceInformation.screenWidth, DeviceInformation.screenHeight);//size of the background image
        this.setBackground(Color.black);
        this.setLayout(null);

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(pictureLocation)));
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(DeviceInformation.screenWidth, DeviceInformation.screenHeight, Image.SCALE_DEFAULT);
        ImageIcon imageIconScaled = new ImageIcon(image);
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0,0, DeviceInformation.screenWidth, DeviceInformation.screenHeight);
        backgroundLabel.setIcon(imageIconScaled);
        this.add(backgroundLabel);
        repaint();
        revalidate();
    }

    @Override
    public void run() {
        try {
            buildScene();

        } catch (IOException e) {

        }
    }
}
