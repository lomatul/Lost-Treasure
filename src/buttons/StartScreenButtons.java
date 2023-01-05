package src.buttons;

import src.levelObjects.Sound;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreenButtons extends BasicBlueButton{

    Color backGroundColor = getBackground();
//    Sound clickSound = new Sound("audio/soundeffects/mixkit-mouse-click-close-1113.wav");

    public StartScreenButtons(int width, int height, String text) {
        super(width, height, text);
        addFocusInOutTransition();
    }

    @Override
    void addButtonStyles(int width, int height, String text){

        super.addButtonStyles(width, height, text);
        setFont(FontInfo.getResizedFont(60f));
        setBorder(BorderFactory.createMatteBorder(3,0,3,3, Color.LIGHT_GRAY));
        setForeground(Color.LIGHT_GRAY);
    }

    @Override
    void addFocusInOutTransition() {

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                clickSound.stop();

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(backGroundColor.brighter());

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                clickSound.stop();

                if(getBackground()!=backGroundColor){
                    setBackground(getBackground().darker());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(backGroundColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(getBackground()!=backGroundColor){
                    setBackground(getBackground().darker());
                }
            }
        });
    }
}
