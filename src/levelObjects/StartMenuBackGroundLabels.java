package src.levelObjects;

import src.setup.DeviceInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartMenuBackGroundLabels extends JLabel implements ActionListener {

    Image backGroundImage;
    float alpha=0.0f;
    public Timer timer = new Timer(0, this);

    Sound animationEffect;
    public StartMenuBackGroundLabels(String path){
        backGroundImage = new ImageIcon(path).getImage();
        addStartMenuStyles();
    }

    private void addStartMenuStyles(){
        setBounds(0,0, DeviceInformation.screenWidth, DeviceInformation.screenHeight);
    }

    @Override
    public synchronized void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(backGroundImage,5,5,null);
    }

    public synchronized void startAnimation(int delay){
        timer.setDelay(delay);
        timer.start();

        animationEffect = new Sound("audio/soundeffects/iconApprearancev2.wav");
        if(timer.isRunning()) {
            animationEffect.play();
        }
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {

        alpha+=0.02f;
        if(alpha>=1.0f){
            alpha = 1.0F;
            timer.stop();
            return;
        }

        repaint();
    }


}
