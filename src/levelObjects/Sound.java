package src.levelObjects;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

public class Sound {
    public Clip clip;
    File fileinput;
    float previousVolume;

    public float currentVolume;

    public FloatControl fc;
    boolean mute;

    public Sound() {

        previousVolume = 0;
        currentVolume = -25;
        mute = false;


    }
    public Sound(String path) {

        setFile(path);
        previousVolume = 0;
        currentVolume = -25;
        mute = false;


    }

    public void setFile(String filePath) {
        try {
            fileinput = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(fileinput);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            fc.setValue(currentVolume);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSoundEffectFile(String fileName) {
        try {
            fileinput = new File("audio/soundeffects/"+fileName+".wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(fileinput);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            fc.setValue(currentVolume);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }


    public void stop() {
        clip.stop();
    }

    public void volumeUp() {
        currentVolume += 1.0f;
        System.out.println("current Volume: " + currentVolume);
        if (currentVolume > 6.0f) {
            currentVolume = 6.0f;
            //6 is max gain of floatcontrol
        }

        fc.setValue(currentVolume);

    }

    //    }
    public void volumeDown() {

        currentVolume -= 1.0f;
        if (currentVolume < -80.0f) {
            currentVolume = -80.0f;
            //lowest float control value or error
        }
        fc.setValue(currentVolume);
    }

    public void volumeMute() {
        if (mute == false) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            mute = true;
        } else if (mute == true) {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            mute = false;
        }
    }
}