package src.levelObjects;

import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;

public class ItemLabel extends JLabel {
    JFrame jFrame;
    JPanel backGroundPanel;
    DeviceInformation deviceInfo;
    FontInfo fontInfo;
    int x;
    int y;
    String text;
    public ItemLabel(JPanel backGroundPanel, FontInfo fontInfo, int x, int y, String text) {
        this.backGroundPanel = backGroundPanel;
        this.fontInfo = fontInfo;
        this.x = x;
        this.y = y;
        this.text = text;
        SetupItemLabel();
    }

    public void SetupItemLabel(){
//        this.setLocation(new Point(x,y));
        this.setBounds(x, y, 150,50);
        this.setBackground(null);
        this.setOpaque(false);
        this.setForeground(Color.white);
        this.setFont(fontInfo.getResizedFont(24f));
        this.setText(text);
        this.setVisible(true);
        backGroundPanel.repaint();
        backGroundPanel.revalidate();
        backGroundPanel.add(this);
        backGroundPanel.repaint();
        backGroundPanel.revalidate();
    }
}
