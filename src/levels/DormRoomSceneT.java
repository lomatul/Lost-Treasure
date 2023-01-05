package src.levels;

import javax.swing.*;
import java.io.IOException;


public class DormRoomSceneT extends ALevelPanel{

    public DormRoomSceneT(JFrame jFrame){
        super(jFrame);
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    @Override
    public synchronized void generateScreenWithAllObjectsAndButtons() throws IOException {
        createButton("images/dormImages/01.png", getX(308), getY(428), getX(68), getY(85));
        createText("Cornflakes Box");
        createButton("images/dormImages/02.png", getX(1188), getY(493), getX(18), getY(37));
        createText("CocaCola Can");
        createButton("images/dormImages/03.png", getX(1235), getY(400), getX(86), getY(65));
        createText("Shoulder Bag");
        createButton("images/dormImages/04.png", getX(1130), getY(730), getX(67), getY(26));
        createText("HeadPhone");
        createButton("images/dormImages/05.png", getX(325), getY(728), getX(43), getY(32));
        createText("Phone");
        createButton("images/dormImages/06.png", getX(419), getY(672), getX(60), getY(19));
        createText("Calculator");
        createButton("images/dormImages/07.png", getX(1102), getY(703), getX(70), getY(25));
        createText("Sunglasses");
        createButton("images/dormImages/08.png", getX(850), getY(384), getX(40), getY(15));
        createText("Garbage");
        createButton("images/dormImages/09.png", getX(482), getY(348), getX(40), getY(48));
        createText("Toilet Paper");
        createButton("images/dormImages/10.png", getX(542), getY(410), getX(72), getY(26));
        createText("Food");
        createButton("images/dormImages/11.png", getX(95), getY(737), getX(168), getY(27));
        createText("Blanket");
        createButton("images/dormImages/12.png", getX(740), getY(520), getX(90), getY(90));
        createText("BackPack");
        createButton("images/dormImages/13.png", getX(515), getY(595), getX(42), getY(80));
        createText("Cloth Pile");
        createButton("images/dormImages/14.png", getX(190), getY(425), getX(85), getY(103));
        createText("Pizza Box");
        createButton("images/dormImages/15.png", getX(1033), getY(417), getX(32), getY(17));
        createText("Folded Clothes");
        createButton("images/dormImages/16.png", getX(894), getY(505), getX(28), getY(28));
        createText("Chips Packet");
        createButton("images/dormImages/17.png", getX(1204), getY(725), getX(110), getY(43));
        createText("Unfolded Cloth");
        createButton("images/dormImages/18.png", getX(722), getY(0) , getX(165), getY(23));
        createText("Quilt");
        createButton("images/dormImages/19.png", getX(924), getY(500), getX(43), getY(20));
        createText("Book");
        createButton("images/dormImages/20.png", getX(1365), getY(751), getX(70), getY(19));
        createText("FoodPlate");
        createButton("images/dormImages/21.png", getX(934), getY(456), getX(44), getY(33));
        createText("Shoes");
        createButton("images/dormImages/22.png", getX(489), getY(400), getX(26), getY(20));
        createText("TeaCup");
        this.add(backgroundLabel);
    }

    @Override
    public String getBackgroundPath() {
        return "images/dormImages/LevelOneMain.png";
    }

    @Override
    public String getBackgroundMusicPath() {
        return "audio/background_music/dormBackgroundAudio.wav";
    }
    @Override
    public String getMessMessage(){
        return "<html>Goodness! The room is such a mess! Where is my present?<br/> Guess I'll have to tidy up.. (Tap to Search)</html>";
    }
}
