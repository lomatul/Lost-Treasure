package src.buttons;

import src.events.MapButtonEvents;
import src.setup.FontInfo;
import src.transitionPanels.MapT;

import javax.swing.*;
import java.awt.*;

public class MapLevelButton extends JButton {
    public MapT mapT;
    int priority;
    public MapButtonEvents mapButtonListener;

    public MapLevelButton(int posx, int posy, int width, int height, String text, int priority, MapT mapT){
        this.priority = priority;
        this.mapT = mapT;
        mapButtonListener = new MapButtonEvents(mapT, this, priority);
        setText(text);
        setBackground(Color.darkGray);
        setForeground(Color.white);
        setFont(FontInfo.getResizedFont(38f));
        setBounds(posx,posy,width,height);
        setFocusPainted(false);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#14171C"),3), BorderFactory.createLineBorder(Color.decode("#55a38b"),2)));

        addMouseListener(mapButtonListener);
        setVisible(true);

        mapT.add(this);
        mapT.repaint();
        mapT.revalidate();
    }

}
