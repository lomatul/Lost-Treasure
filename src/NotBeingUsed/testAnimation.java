package src.NotBeingUsed;

import src.levels.ALevelPanel;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import static java.lang.Math.ceil;

public class testAnimation extends JPanel implements ActionListener {
    JFrame jFrame;

    Timer timer;

    JPanel nextScene;
    //    DeviceInformation deviceInfo;
//    FontInfo fontInfo;
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
    int Lefthalforiginx ;
    int leftHalfpoint1x;
    int leftHalfpoint2x;
    int leftHalfpoint3x;
    int leftHalfpoint4x;
    int leftHalfpoint1y;
    int leftHalfpoint2y;
    int leftHalfpoint3y;
    int leftHalfpoint4y;

    int rightHalfpoint1x;
    int rightHalfpoint2x;
    int rightHalfpoint3x;
    int rightHalfpoint4x;
    int rightHalfpoint1y;
    int rightHalfpoint2y;
    int rightHalfpoint3y;
    int rightHalfpoint4y;

    boolean leftHalftransitionIn;
    boolean rightHalftransitionIn;

    int Lefthalforiginy;
    int Righthalforiginx ;
    int Righthalforiginy;
    public testAnimation(){
        leftHalftransitionIn = false;
        rightHalftransitionIn = false;
        leftHalfpoint1y = 0;
        leftHalfpoint1x = 0;
//        leftHalfpoint2x = 1920-200;
        leftHalfpoint2x = 0;
        leftHalfpoint2y = 0;
//        leftHalfpoint3x = 400;
        leftHalfpoint3x = 0;
//        leftHalfpoint3y = 1080;
        leftHalfpoint3y = 0;
        leftHalfpoint4x = 0;
        leftHalfpoint4y = 1080;


//        rightHalfpoint1x = 1920-300 ;
        rightHalfpoint1x = 1920 ;
        rightHalfpoint2x = 1920;
        rightHalfpoint3x = 1920;
//        rightHalfpoint4x = 300;
        rightHalfpoint4x = 1920;
//        rightHalfpoint1y = 0;
        rightHalfpoint1y = 1080;
        rightHalfpoint2y = 0;
        rightHalfpoint3y = 1080;
        rightHalfpoint4y = 1080;

        setSize(DeviceInformation.screenWidth, DeviceInformation.screenHeight);
//        setPreferredSize(new Dimension(DeviceInformation.screenWidth, DeviceInformation.screenHeight));
//        setBackground(Color.decode("#14171C"));
//        setLayout(null);
//        setVisible(true);

    }

//    public void changeNextScene(JPanel nextScene){
//        this.nextScene = nextScene;
//    }
//
//    private void buildScene(){
//        setPreferredSize(new Dimension(DeviceInformation.screenWidth, DeviceInformation.screenHeight));
//        setBackground(Color.decode("#14171C"));
//        setLayout(null);
//    }
//
    public void initializeTimer(){
        timer = new Timer(10,this);
        timer.start();
        timerStopped=false;
        loadingBarWidth=1;
        animationStartTime = System.currentTimeMillis();
        animationRunTime=0;
    }
//
    public void paint(Graphics g){
        super.paint(g); //paint background

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.pink);

        if(leftHalftransitionIn){
            g2d.setColor(Color.green);
        }

//        int x[]={0,1920-200,400, 0};

//        int y[]={0,0,1080, 1080};
//
        int x[]={leftHalfpoint1x,leftHalfpoint2x,leftHalfpoint3x, leftHalfpoint4x};
        int y[]={leftHalfpoint1y,leftHalfpoint2y,leftHalfpoint3y, leftHalfpoint4y};


        int x2[]={rightHalfpoint1x,rightHalfpoint2x, rightHalfpoint3x, rightHalfpoint4x};
        int y2[]={rightHalfpoint1y,rightHalfpoint2y, rightHalfpoint3y, rightHalfpoint4y};


//        g2d.drawPolygon(x,y,4);
        g2d.fillPolygon(x,y,4);
        if(rightHalftransitionIn){
            g2d.setColor(Color.pink);
        }else{
            g2d.setColor(Color.green);
        }

        g2d.fillPolygon(x2,y2,4);
//        g2d.drawPolygon(x2,y2,4);


    }
//
    @Override
    public void actionPerformed(ActionEvent e) {

        if(leftHalftransitionIn) {
            if (leftHalfpoint2x != 0) {
                leftHalfpoint2x -= 20;
            }

            if (leftHalfpoint3x != 0) {
                leftHalfpoint3x -= 20;
            } else {
                leftHalfpoint3y -= 16;
            }

        }else{
            if(leftHalfpoint2x<(1920-200)){
                leftHalfpoint2x+=20;
            }

            if (leftHalfpoint3y < 1080) {
                leftHalfpoint3y += 16;
            } else if(leftHalfpoint3x<400) {
                leftHalfpoint3x += 20;
            }

            if(leftHalfpoint2x >= 1920-200 && leftHalfpoint3y >= 1080){
                leftHalftransitionIn = true;
            }

        }

        if(rightHalftransitionIn) {
            if (rightHalfpoint1x != 1920) {
                rightHalfpoint1x += 20;
            } else {
                rightHalfpoint1y += 16;
            }

            if (rightHalfpoint4x != 1920) {
                rightHalfpoint4x += 20;
            }
        }else{
            if(rightHalfpoint1y>0){
                rightHalfpoint1y-=16;
            }else{
                rightHalfpoint1x-=20;
            }

            if(rightHalfpoint4x>300){
                rightHalfpoint4x-=20;
            }

            if(rightHalfpoint1x<=1920-300 && rightHalfpoint4x>=300){
                rightHalftransitionIn = true;
            }
        }
        repaint();
    }
//
//    public void LoadMenu(){
//
////        Map map = new Map(jFrame);
//        jFrame.remove(this);
////        jFrame.add(map);
//        jFrame.revalidate();
//        jFrame.repaint();
//    }
//



}
