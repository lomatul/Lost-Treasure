package src.events;

import src.popups.LoginDialog;
import src.transitionPanels.StartMenuScreenT;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginButtonEvent implements MouseListener {
    JFrame jFrame;
    StartMenuScreenT startMenuScreenT;

    public LoginButtonEvent(JFrame jFrame, StartMenuScreenT startMenuScreenT){
        this.jFrame = jFrame;
        this.startMenuScreenT = startMenuScreenT;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        LoginDialog loginDialog = new LoginDialog(jFrame);
        loginDialog.addStartMenuSceneT(startMenuScreenT);
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
