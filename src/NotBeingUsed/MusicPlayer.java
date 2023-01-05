package src.NotBeingUsed;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.URL;

public class MusicPlayer {



    Clip clip;
    public void  setFile(URL name){
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void play(URL name){
        try{
            clip.setFramePosition(0);
            clip.start();
        }
        catch(Exception e){
            System.out.println("cant play music if music can't be found yo");
        }
    }

    public void loop(URL name)
    {
        try{
            clip.loop(clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e){
            System.out.println("Can't loop music if music is null broo");
        }
    }


    public  void  stop(URL name){
        try{
            clip.stop();
        }
        catch(Exception e){
            System.out.println("can't stop music, cuz music is null");
        }
    }

    public  void playMusic(URL url) {
        this.setFile(url);
        this.play(url);
        this.loop(url);
    }


}
