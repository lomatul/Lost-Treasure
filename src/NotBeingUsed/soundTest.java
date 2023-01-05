package src.NotBeingUsed;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class soundTest extends JPanel {

    /**
     * @return main sound control object
     * @throws Exception for any problem
     */
    private FloatControl getVolumeControl() throws Exception {
        try {
            Mixer.Info mixers[] = AudioSystem.getMixerInfo();
            for (Mixer.Info mixerInfo : mixers) {
                Mixer mixer = AudioSystem.getMixer(mixerInfo);
                mixer.open();

                //we check only target type lines, because we are looking for "SPEAKER target port"
                for (Line.Info info : mixer.getTargetLineInfo()) {
                    if (info.toString().contains("SPEAKER")) {
                        Line line = mixer.getLine(info);
                        try {
                            line.open();
                        } catch (IllegalArgumentException iae) {}
                        return (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("problem creating volume control object:"+ex);
            throw ex;
        }
        throw new Exception("unknown problem creating volume control object");
    }

    public soundTest(){
        JSlider slider = new JSlider();
        add(slider);

        //this is for setting the value
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider src = (JSlider)e.getSource();
                //if (src.getValueIsAdjusting()) return; //optional
                if (src.getValue() % 5 !=0) return;
                float value = src.getValue() / 100.0f;
                try {
                    getVolumeControl().setValue(value);
                    //you can put a click play code here to have nice feedback when moving slider
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        //and this is for getting the value
        try {
            slider.setValue((int) (getVolumeControl().getValue()*100.0f));
        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
