package src.transitionPanels;

import src.DatabaseConnection.OracleDatabase;
import src.levels.CDS_LevelPanelT;
import src.popups.FinalLevelCompletedPopUp;
import src.popups.LevelUnlockPopUp;
import src.popups.LoginDialog;
import src.popups.SignupDialog;
import src.setup.DeviceInformation;
import src.setup.FontInfo;
import src.DatabaseConnection.PlayerInfo;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameManager{

    public String testString;

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        new GameManager();
//        OracleDatabase oracle = new OracleDatabase();
//        try {
//            test(oracle);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        test();
    }

    public static void test(){
        OracleDatabase oracleDatabase = new OracleDatabase();
        System.setProperty("sun.java2d.uiScale", "1.0");
        FontInfo fontInfo = new FontInfo();
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(300, 100, 600, 600);
        jFrame.setVisible(true);

        PlayerInfo playerInfo = new PlayerInfo(0);
//        FinalLevelCompletedPopUp finalLevelCompletedPopUp = new FinalLevelCompletedPopUp(jFrame, 6);

    }
    public GameManager() throws IOException {
        System.setProperty("sun.java2d.uiScale", "1.0");
        DeviceInformation deviceInformation = new DeviceInformation();
        FontInfo fontInfo = new FontInfo();
        PlayerInfo player = new PlayerInfo(0); // taken from database

        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        System.out.println("X:" +  mouseX);
        System.out.println("Y:" + mouseY);

        System.out.println(deviceInformation.screenHeight + " " + deviceInformation.screenWidth);

        /* Set up the frame*/
        JFrame jFrame = new JFrame();
        jFrame.setBackground(Color.black);
        jFrame.setForeground(Color.black);
        jFrame.setTitle("Lost Treasures");
        jFrame.setIconImage(new ImageIcon("images/icons/logo2.png").getImage());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setUndecorated(true);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setBackground(Color.decode("#14171C"));
        jFrame.pack();
        jFrame.setVisible(true);


        //thread pool
        ExecutorService pl = Executors.newFixedThreadPool(1);

        StartMenuScreenT startMenu = new StartMenuScreenT(jFrame);

        MessageFromMomT messageFromMomT = new MessageFromMomT(jFrame);
        LoadingAnimationT loadingAnimationT = new LoadingAnimationT(jFrame,3,messageFromMomT);
        MapT mapT = new MapT(jFrame, loadingAnimationT);


        startMenu.PrepareForSceneTransition(loadingAnimationT, null); //nextscene is not being used
                                                                                //perhaps later we can use player info to change next scene
                                                                                //for loadingscene

        loadingAnimationT.startMenuScreenT = startMenu;
        loadingAnimationT.mapT = mapT;
        loadingAnimationT.messageFromMomT = messageFromMomT;
        messageFromMomT.PrepareForSceneTransition(loadingAnimationT, mapT);
       // CDS_LevelPanelT cds_levelPanelT = new CDS_LevelPanelT(jFrame);
        pl.execute(startMenu);
        pl.execute(mapT);
        pl.execute(loadingAnimationT);
        pl.execute(messageFromMomT);


      //  pl.execute(cds_levelPanelT);
        jFrame.add(startMenu); //should be startmenu during real play
        pl.shutdown();

        PlayerInfo.gameProgress = 5;

    }

    /*TODO:
    - tie all the music and sound effects together, or make them seperate, people may find it too loud;
    - try re-rendering dormscene if there's time, it looks bad compared to it's fancy classroom and fancy library brothers
    - add translucent background image for text Box in AlevelPanels, black box looks kinda bad;
    - add background image for timer label and score label;
    - the buttons in mapT looks kinda bad, I vote changing to transparent buttons with  text on them;
    - time over, do you want to exit to map, all these confirmation dialogue's text is too small. should be larger and should be scaled

    // bugs
    - dorm v2 is missing 2 objects
    - innitial login sounds twice
    - map buttons refresh during innital game start
    - map button refresh after DOrm v2
    - innitial login click sounds too loud
    - bring arrow gif closer
    - insert meow
    */

    /**
     * remember to fix Passing score in AlevelPanel to 400
     * remember to uncomment the if condition in the onclick event in MapBUttonEvents
     */
}
