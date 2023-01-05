package src.levelObjects;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HintAnimationGif extends JLabel{

    public void setup(){
        int sizeX = 200;
        int sizeY = 200;

        ImageIcon gif = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Gifs/playing_brown_cat.gif")));
        gif.setImage(gif.getImage().getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT));
        setBounds(600,500, sizeX,sizeY);

        setIcon(gif);
        setVisible(true);
        setVisible(false);
    }
}
