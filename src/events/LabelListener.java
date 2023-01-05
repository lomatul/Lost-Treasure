package src.events;

import src.levels.ALevelPanel;
import src.popups.HintConfirmationDialogue;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LabelListener implements MouseListener {

    JFrame jFrame;
    ALevelPanel backgroundPanel;
    JLabel motherLabel;
    int indexOfObjectButton;
    public LabelListener(JFrame jFrame, ALevelPanel backgroundPanel, JLabel motherLabel, int index){
        this.indexOfObjectButton = index;
        this.jFrame = jFrame;
        this.backgroundPanel = backgroundPanel;
        this.motherLabel = motherLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        backgroundPanel.hintConfirmationDialogue = new HintConfirmationDialogue(jFrame, backgroundPanel, indexOfObjectButton);
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
