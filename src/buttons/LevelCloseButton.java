package src.buttons;

import src.levelObjects.Sound;
import src.setup.DeviceInformation;
import src.setup.FontInfo;
import src.popups.LevelToMapConfirmationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelCloseButton extends JButton {

    //too many one line methods

    Sound alert;

    JPanel jPanel;
    public LevelCloseButton(String text, JFrame jFrame, JPanel jPanel){
//        this.deviceInformation = deviceInformation;
//        this.fontInfo = fontInfo;
        setDefaultPosition();
        removeBackground();
        removeBorder();
        removeFocusPaint();
        removeContentArea();
        assignFont(FontInfo.getResizedFont(35f));
        addExitText(text);
        setDefaultTextColor();
//        addCloseActions(fontInfo,jFrame,exitConfirmation);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LevelToMapConfirmationDialog confirmationDialog = new LevelToMapConfirmationDialog(jFrame,jPanel);
                alert= new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                jPanel.repaint();
                jPanel.revalidate();
                confirmationDialog.repaint();
                confirmationDialog.revalidate();
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
        jFrame.revalidate();
        jFrame.repaint();

    }



    public void setPosition(int Posx, int Posy, int width, int height){
        setBounds(Posx,Posy,width,height);
    }

    private void setDefaultPosition(){
        setBounds(DeviceInformation.screenWidth -70, 10, 60,60);
    }
    private void removeBackground(){
        setBackground(null);
    }

    private void removeBorder(){
        setBorder(null);
    }

    private void removeFocusPaint(){
        setFocusPainted(false);
    }

    private void removeContentArea(){
        setContentAreaFilled(false);
    }

    private void assignFont(Font assignedFont){
        setFont(assignedFont);
    }

    private void addExitText(String text){
        setText(text);
    }

    public void setTextColor(Color color){
        setForeground(color);
    }

    private void setDefaultTextColor(){
        setForeground(Color.white);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);

        g2d.setPaint(Color.decode("#14171C"));
        g2d.fillOval(5, 5,50,50);

        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.WHITE);
        g2d.drawOval(5,5,50,50);
        super.paint(g);
    }
}
