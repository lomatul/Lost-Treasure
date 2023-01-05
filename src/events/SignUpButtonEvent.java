package src.events;

import src.popups.SignupDialog;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SignUpButtonEvent implements MouseListener {

    JFrame jFrame;
    public SignUpButtonEvent(JFrame jFrame){
        this.jFrame = jFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SignupDialog signupDialog = new SignupDialog(jFrame);
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
}
