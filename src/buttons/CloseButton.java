package src.buttons;

import src.levelObjects.Sound;
import src.popups.BackToMenuDialogue;
import src.setup.DeviceInformation;
import src.popups.ExitWindowConfirmationDialog;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CloseButton extends JButton {

    //too many one line methods
//    DeviceInformation deviceInformation;
//    FontInfo fontInfo;

    public CloseButton(String text, JFrame jFrame, JPanel backgroundPanel){
//        this.deviceInformation = deviceInformation;
//        this.fontInfo = fontInfo;
        setDefaultPosition();
        removeBackground();
        removeBorder();
        removeFocusPaint();
        removeContentArea();
        assignFont(FontInfo.getResizedFont(50f));
        addExitText(text);
        setDefaultTextColor();


//        addCloseActions(fontInfo,jFrame,exitConfirmation);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BackToMenuDialogue backToMenuDialogue = new BackToMenuDialogue(jFrame, backgroundPanel);

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
        setBounds(DeviceInformation.screenWidth -50, 5, 50,50);
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

//    private void addCloseActions(FontInfo fontInfo, JFrame jFrame, ConfirmationWindowPopup exitConfirmation){
//        addMouseListener(new closeWindowMouseEvents(fontInfo,jFrame, exitConfirmation));
//    }
}
