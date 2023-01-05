package src.transitionPanels;

import src.levels.ALevelPanel;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static java.lang.Math.ceil;

public class LoadingAnimationT extends JPanel implements ActionListener,Runnable {
    public boolean LevelOver_ProgressUpdated;
    public int level_number = -1;
    JFrame jFrame;
    public JPanel nextScene;
    public int calledBy;
    public boolean iNeedYouToRemoveMe;
    Timer timer;
    JLabel loadingText;
    long animationStartTime;
    int loadingBarPosX, loadingBarPosY, loadingBarWidth;
    int loadingDotPosX;
    int loadingDotPosY;
    int loadingDotMaxX; //maximum x position of the dot, will return to initial position
    int loadingDotCurrentX; //current dot position, will be used by paint/repaint
    int animationDuration;

    boolean timerStopped;
    long animationRunTime;
    int increment;
    public StartMenuScreenT startMenuScreenT;
    public MapT mapT;
    public MessageFromMomT messageFromMomT;
    public LoadingAnimationT(JFrame jFrame, int animationDuration, JPanel nextScene){
        this.jFrame = jFrame;
//        this.deviceInfo = deviceInformation;
//        this.fontInfo = fontInfo;
        this.animationDuration = animationDuration;
        this.nextScene = nextScene;
        this.increment = 500/(animationDuration*20);
        this.LevelOver_ProgressUpdated = false;

//        timer.start();
//        animationStartTime = System.nanoTime();

    }

    public void changeNextScene(JPanel nextScene){
        this.nextScene = nextScene;
    }

    private void buildScene(){
        setPreferredSize(new Dimension(DeviceInformation.screenWidth, DeviceInformation.screenHeight));
        setBackground(Color.decode("#14171C"));
        setLayout(null);
        SetLoadingText();
    }

    public void initializeTimer(){
        jFrame.revalidate();
        jFrame.repaint();

        timer = new Timer(50,this);
        timer.start();
        timerStopped=false;
        loadingBarWidth=1;
        animationStartTime = System.currentTimeMillis();
        animationRunTime=0;
    }
    private void initializeAnimationParameters(){
        loadingBarPosX = DeviceInformation.screenWidth /3;
        loadingBarWidth =1;
        loadingBarPosY = DeviceInformation.screenHeight /2 + 50;
        loadingDotPosY = DeviceInformation.screenHeight /2+120;
        loadingDotPosX = DeviceInformation.screenWidth /2 +65;
        loadingDotCurrentX = loadingDotPosX;
        loadingDotMaxX = loadingDotCurrentX +50;
    }
    private void SetLoadingText(){
        loadingText =  new JLabel("Loading");
        loadingText.setFont(FontInfo.getResizedFont(50f));
        loadingText.setBounds(DeviceInformation.screenWidth /2 - 50, DeviceInformation.screenHeight /2+100,200,50);
        loadingText.setBackground(null);
        loadingText.setForeground(Color.white);
        add(loadingText);
    }

    public void paint(Graphics g){
        super.paint(g); //paint background
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillOval(loadingDotCurrentX, loadingDotPosY, (int)ceil(0.006*DeviceInformation.screenWidth),(int)ceil((0.011*DeviceInformation.screenHeight)));
        g2d.fillRect(loadingBarPosX, loadingBarPosY +10, loadingBarWidth,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        animationRunTime = (System.currentTimeMillis()-animationStartTime)/1000;
        if(animationRunTime > animationDuration){
            System.gc(); //calling garbage collector

            timerStopped=true;
            timer.stop();

            jFrame.remove(this);
            jFrame.add(nextScene);

            if(nextScene instanceof ALevelPanel){
                ((ALevelPanel) nextScene).StartLevel();
            }
            else if((nextScene instanceof MapT) && LevelOver_ProgressUpdated){
                ((MapT) nextScene).ArrowGif.setVisible(false);
                ((MapT) nextScene).ShowUnlockAnimation(level_number);

                LevelOver_ProgressUpdated = false;
                level_number = -1;

            }
            else if(nextScene instanceof MapT){
                ((MapT) nextScene).fixArrowPosition();
            }

            if(nextScene instanceof MapT){

                ((MapT) nextScene).mapMusic.play();
                ((MapT) nextScene).mapMusic.loop();
                ((MapT) nextScene).refreshButtonGrayness();
                ((MapT) nextScene).setVisibleCutOuts();
//                ((MapT) nextScene).fixArrowPosition();
            }

            jFrame.revalidate();
            jFrame.repaint();
//            LoadMenu(this.jFrame);
//            LoadMenu();
        }

        if(loadingBarWidth <DeviceInformation.screenWidth*4/5){
            loadingBarWidth = loadingBarWidth +increment;
        }

        if (loadingDotCurrentX > loadingDotMaxX){
            loadingDotCurrentX = loadingDotPosX;
        }else{
            loadingDotCurrentX += 2;
        }

        repaint();
    }

    public void LoadMenu(){

//        Map map = new Map(jFrame);
        jFrame.remove(this);
//        jFrame.add(map);
        jFrame.revalidate();
        jFrame.repaint();
    }


    @Override
    public void run() {

        buildScene();
        initializeAnimationParameters();
//        initializeTimer();
    }

}
