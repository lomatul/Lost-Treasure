package src.levelObjects;

import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;

public class StartMenuLabel extends JLabel {


    public StartMenuLabel(){
        addLabelStyles();
    }

    private void addLabelStyles(){
        setFont(FontInfo.getResizedFont((float)0.09*(DeviceInformation.screenWidth)));
        setText("LOST TREASURES");
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.white);
        setBackground(Color.decode("#14171C"));
    }

}
