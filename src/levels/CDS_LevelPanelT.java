package src.levels;

import src.setup.DeviceInformation;

import javax.swing.*;
import java.io.IOException;


public  class CDS_LevelPanelT extends ALevelPanel {



    public CDS_LevelPanelT(JFrame jFrame){
        super(jFrame);
    }

    @Override
    public int getLevelNumber() {
        return 5;
    }

    @Override
    public synchronized void generateScreenWithAllObjectsAndButtons() throws IOException {

        createButton("images/cdsimages/bag.png", getX(308), getY(658), getX(100), getY(185));
        createText("Bag");
        createButton("images/cdsimages/book.png", getX(108), getY(558), getX(98), getY(45));
        createText("NoteBook");
        createButton("images/cdsimages/change.png", getX(428), getY(688), getX(38), getY(35));
        createText("Money");
        createButton("images/cdsimages/glasses.png", getX(688), getY(678), getX(68), getY(45));
        createText("Glasses");
        createButton("images/cdsimages/headphones.png", getX(78), getY(648), getX(68), getY(55));
        createText("Headphones");
        createButton("images/cdsimages/key.png", getX(1128), getY(518), getX(48), getY(40));
        createText("KeyRing");
        createButton("images/cdsimages/mug.png", getX(248), getY(598), getX(38), getY(45));
        createText("Travel Mug");
        createButton("images/cdsimages/phone.png", getX(908), getY(548), getX(48), getY(35));
        createText("Phone");
        createButton("images/cdsimages/wallet.png", getX(1068), getY(484), getX(58), getY(55));
        createText("Wallet");
        createButton("images/cdsimages/watch.png", getX(1288), getY(638), getX(38), getY(45));
        createText("Watch");

        this.add(backgroundLabel);
    }

    @Override
    public String getBackgroundPath() {
        return "images/cdsimages/cds.png";
    }

    @Override
    public String getBackgroundMusicPath() {
        return "audio/background_music/dormBackgroundAudio.wav";
    }
    @Override
    public String getMessMessage(){
        return "<html>There's no one here right now.<br/>Let's look around here. (Tap to Search)</html>";
    }
}
