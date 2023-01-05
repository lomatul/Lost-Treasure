package src.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SceneObjectEvents implements MouseListener {
    public JLabel imageLabel;
    JPanel scenePanel;
    public SceneObjectEvents(JLabel imageLabel, JPanel scenePanel){
        this.imageLabel = imageLabel;
        this.scenePanel = scenePanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        imageLabel.setVisible(false);
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
