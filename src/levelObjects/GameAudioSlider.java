package src.levelObjects;

import javax.swing.*;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

import java.awt.Color;

import java.awt.geom.Ellipse2D;

public class GameAudioSlider extends BasicSliderUI {

    public GameAudioSlider(JSlider jSlider){
        super(jSlider);
    }

    @Override
    public void paintTrack(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode("#14171C"));
        g2d.fill(trackRect);
        g2d.setStroke(new BasicStroke(5));

        g2d.setPaint(Color.WHITE);
        g2d.drawLine(trackRect.x * 3, trackRect.y + trackRect.height / 2,
                    trackRect.x + trackRect.width - trackRect.x * 3, trackRect.y + trackRect.height / 2);


        slider.repaint();

    }

    @Override
    public void paintThumb(Graphics g) {
        Rectangle knobBounds = thumbRect;
        int w = knobBounds.height;
        int h = knobBounds.height;
        Graphics2D g2d = (Graphics2D) g.create();
        Shape thumbShape = createThumbShape(w - 1, h - 1);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if(knobBounds.x < trackRect.x*3){
            knobBounds.x = trackRect.x*2;
        }

        if(knobBounds.x >trackRect.x + trackRect.width-trackRect.x*3){
            knobBounds.x = trackRect.x + trackRect.width-trackRect.x*4;
        }


        g2d.translate(knobBounds.x, trackRect.y);
        g2d.setColor(Color.white);
        g2d.fill(thumbShape);

        g2d.dispose();

        slider.repaint();
    }


    private Shape createThumbShape(int width, int height) {
        Ellipse2D shape = new Ellipse2D.Double(0, 0, width, height);
        return shape;
    }
}


