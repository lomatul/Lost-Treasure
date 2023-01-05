package src.popups;

import src.levelObjects.GameAudioSlider;
import src.levelObjects.Sound;
import src.setup.DeviceInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Objects;

public class ChangeVolumeDialog extends JDialog {

    public ChangeVolumeDialog(JFrame jFrame, Sound sound){
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#14171C"));
//        setLayout(new GridLayout(2,1));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));

        JSlider jSlider = new JSlider(-40,6);
        jSlider.setFocusable(false);
        jSlider.setBackground(null);

        ImageIcon audioIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/icons/upAudio.png")));
        Image image = audioIcon.getImage().getScaledInstance(30,32,Image.SCALE_SMOOTH);
        audioIcon = new ImageIcon(image);

        JLabel upAudio = new JLabel(audioIcon);
        upAudio.setSize(30,40);

        audioIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/icons/noAudio.png")));
        image = audioIcon.getImage().getScaledInstance(30,32,Image.SCALE_SMOOTH);
        audioIcon = new ImageIcon(image);

        JLabel noAudio = new JLabel(audioIcon);
        noAudio.setSize(30,40);
        add(noAudio);
        add(jSlider);
        add(upAudio);
        jSlider.setBorder(new EmptyBorder(10,0,10,0));
//        jSlider.setBorder(new LineBorder(Color.PINK,18));
        setLocation(DeviceInformation.screenWidth-300, 80);
        setSize(300,60);
        jSlider.setValue((int)sound.fc.getValue());
//        setBounds(De.viceInformation.screenWidth-300,50,100,100);
        setResizable(false);
        System.out.println(jSlider.getWidth() + " " + jSlider.getHeight());

        jSlider.setUI(new GameAudioSlider(jSlider));
        jSlider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sound.currentVolume = jSlider.getValue();
                if(sound.currentVolume == -40){
                    sound.currentVolume = -80;
                }
                sound.fc.setValue(sound.currentVolume);
                System.out.println(jSlider.getValue());
                jSlider.repaint();
            }
        });



        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);


    }
}
