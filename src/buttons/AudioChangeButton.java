package src.buttons;

import src.levelObjects.Sound;
import src.popups.ChangeVolumeDialog;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AudioChangeButton extends JButton {


    public AudioChangeButton (JFrame jFrame, Sound sound){
//        setBackground(null);
//        setBorder(null);
//        setFocusPainted(false);
//        setContentAreaFilled(false);
        setFont(FontInfo.getResizedFont(35f));
        setText("♬");
        setForeground(Color.white);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setVisible(true);
        setBounds(DeviceInformation.screenWidth -140, 10, 60,60);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangeVolumeDialog changeVolumeDialog = new ChangeVolumeDialog(jFrame,sound);
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


    @Override
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
