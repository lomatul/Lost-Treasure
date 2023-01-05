package src.NotBeingUsed;

import src.buttons.CloseButton;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartMenuScreen extends JPanel {
    JFrame jFrame;
    JLabel gameTitle;
    JButton startGameButton;
    DeviceInformation deviceInfo;
    FontInfo fontInfo;
    CloseButton closeButton;
    public StartMenuScreen(JFrame jFrame, DeviceInformation deviceInformation, FontInfo fontInfo){
        this.jFrame = jFrame;
        this.deviceInfo = deviceInformation;
        this.fontInfo = fontInfo;
        createBackgroundPanel();
        addCustomWindowCloseButton(jFrame);
        createStartGameButton(jFrame);
        createGameTitleLabel();
        this.add(gameTitle);
        this.add(startGameButton);
        jFrame.add(this);

    }



    public void createBackgroundPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(deviceInfo.screenWidth, deviceInfo.screenHeight));
        this.setBackground(Color.decode("#14171C"));
        this.setForeground(Color.decode("#C64C1D"));
    }

    public void createGameTitleLabel(){
        gameTitle = new JLabel();
        gameTitle.setBounds(0,deviceInfo.screenHeight/2,deviceInfo.screenWidth,100);
        gameTitle.setFont(fontInfo.getResizedFont(100f));
        gameTitle.setText("LOST TREASURES");
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        gameTitle.setForeground(Color.white);
        gameTitle.setBackground(new Color(0,0,0,0));
    }

    public void createStartGameButton(JFrame jFrame){
        startGameButton = new JButton("Start Game");
        startGameButton.setBounds(deviceInfo.screenWidth/2-150,2*deviceInfo.screenHeight/3, 300,70);
        startGameButton.setHorizontalAlignment(JButton.CENTER);
        startGameButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(0,20,0,20)));
        startGameButton.setBackground(null);
        startGameButton.setForeground(Color.white);
        startGameButton.setFocusPainted(false);
        startGameButton.setContentAreaFilled(false);
        startGameButton.setOpaque(true);
        startGameButton.setFont(fontInfo.getResizedFont(50f));


        startGameButton.addMouseListener(new MouseListener() {
            boolean isHovering = false;
            @Override
            public void mouseClicked(MouseEvent e) {
                StartLoadScreen();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                startGameButton.setBackground(new Color(50,70,120)); //hoyna
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                startGameButton.setBackground(null);
//                if(isHovering)
//                    StartLoadScreen();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isHovering = true;
                startGameButton.setBackground(new Color(0,40,80));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovering = false;
                startGameButton.setBackground(null);
            }
        });
    }

    public void StartLoadScreen(){
        jFrame.remove(this);
//        DecoyAnimation decoyAnimation = new DecoyAnimation(new Map(jFrame, deviceInfo,fontInfo),jFrame, deviceInfo,fontInfo,7);
//        DecoyAnimation decoyAnimation = new DecoyAnimation(new DormRoom(jFrame, deviceInfo,fontInfo),jFrame, deviceInfo,fontInfo,7);
        jFrame.revalidate();
        jFrame.repaint();
    }

    public void addCustomWindowCloseButton(JFrame jFrame){
        closeButton = new CloseButton("X",jFrame);
        this.add(closeButton);
    }


}
