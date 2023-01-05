package src.popups;

import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AccountDialogTextArea extends JTextArea {


    public AccountDialogTextArea(int width, int height){
        addStyles(width,height);
    }
    
    private void addStyles(int width, int height){
        setFont(FontInfo.getResizedFont(24f));
        setBackground(Color.white);
        setBorder(new LineBorder(Color.white, 3));
        setPreferredSize(new Dimension(width, height));
        setForeground(new Color(2, 2, 23, 122));
        getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");
        getInputMap().put(KeyStroke.getKeyStroke("TAB"), "none");
        setVisible(true);
    }

    final Color focusColor = new Color(2, 2, 23, 255);
    final Color outOfFocusColor = new Color(2, 2, 23, 122);

    public void addFocusEvent(String outOfFocus){
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setFocusGainedStyle(outOfFocus);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setFocusLostStyle(outOfFocus);
            }
        });
        
    }

    private void setFocusLostStyle(String outOfFocus) {
        if(getText().equals("") || getText().isBlank() || getText().isEmpty()) {
            setForeground(outOfFocusColor);
            repaint();
            revalidate();
            setText(outOfFocus);
        }
    }

    private void setFocusGainedStyle(String outOfFocus){
        if(getText().equals("") || getText().isBlank() || getText().isEmpty()|| getText().equals(outOfFocus)) {
            setForeground(focusColor);
            repaint();
            revalidate();
            setText("");
        }
    }
}
