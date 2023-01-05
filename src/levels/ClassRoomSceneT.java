package src.levels;

import src.setup.DeviceInformation;

import javax.swing.*;
import java.io.IOException;

public class ClassRoomSceneT extends ALevelPanel{

    public ClassRoomSceneT(JFrame jFrame){
        super(jFrame);
    }
    @Override
    public int getLevelNumber() {
        return 3;
    }
    @Override
    public String getBackgroundPath() {
        return "images/Classroom images/classroomMain.PNG";
    }

    @Override
    public String getBackgroundMusicPath() {
        return "audio/background_music/classroomAudio_The Deli - 5_32PM.wav";
    }

    @Override
    public String getMessMessage(){
        return "<html>I know it's a free period but did everyone have to leave their stuff here?<br/>At least I can search in peace now. (Tap to Search)</html>";
    }

    @Override
    public synchronized void generateScreenWithAllObjectsAndButtons() throws IOException {

        createButton("images/Classroom images/classroom objects/item 0.PNG", DeviceInformation.screenWidth *0/1920, DeviceInformation.screenHeight *435/1080,
                DeviceInformation.screenWidth *25/1920, DeviceInformation.screenHeight *50/1080);
        createText("<html>Brown Coffee<br/> cup </html>");
        createButton("images/Classroom images/classroom objects/item 1.PNG",DeviceInformation.screenWidth *1837/1920, DeviceInformation.screenHeight *640/1080,
                DeviceInformation.screenWidth *80/1920, DeviceInformation.screenHeight *20/1080);
        createText("Pencil");
        createButton("images/Classroom images/classroom objects/item 2.PNG",DeviceInformation.screenWidth *1782/1920, DeviceInformation.screenHeight *658/1080,
                DeviceInformation.screenWidth *110/1920, DeviceInformation.screenHeight *35/1080);
        createText("Chips Packet");
        createButton("images/Classroom images/classroom objects/item 3.PNG",DeviceInformation.screenWidth *1702/1920, DeviceInformation.screenHeight *640/1080,
                DeviceInformation.screenWidth *60/1920, DeviceInformation.screenHeight *30/1080);
        createText("Eraser");
        createButton("images/Classroom images/classroom objects/item 4.PNG",DeviceInformation.screenWidth *1554/1920, DeviceInformation.screenHeight *535/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *50/1080);
        createText("Pokemon Ball");
        createButton("images/Classroom images/classroom objects/item 5.PNG",DeviceInformation.screenWidth *1703/1920, DeviceInformation.screenHeight *528/1080,
                DeviceInformation.screenWidth *50/1920, DeviceInformation.screenHeight *50/1080);
        createText("Orange");
        createButton("images/Classroom images/classroom objects/item 6.PNG",DeviceInformation.screenWidth *1850/1920, DeviceInformation.screenHeight *375/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *120/1080);
        createText("Lamp");
        createButton("images/Classroom images/classroom objects/item 7.PNG", DeviceInformation.screenWidth *1871/1920, DeviceInformation.screenHeight *476/1080,
                DeviceInformation.screenWidth *60/1920, DeviceInformation.screenHeight *40/1080);
        createText("Tissue Box");
        createButton("images/Classroom images/classroom objects/item 8.PNG", DeviceInformation.screenWidth *1683/1920, DeviceInformation.screenHeight *402/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *60/1080);
        createText("Milk Bottle");
        createButton("images/Classroom images/classroom objects/item 9.PNG", DeviceInformation.screenWidth *1481/1920, DeviceInformation.screenHeight *427/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *50/1080);
        createText("Brown Coffee cup");
        createButton("images/Classroom images/classroom objects/item 10.PNG", DeviceInformation.screenWidth *1523/1920, DeviceInformation.screenHeight *340/1080,
                DeviceInformation.screenWidth *30/1920, DeviceInformation.screenHeight *70/1080);
        createText("Water Bottle");
        createButton("images/Classroom images/classroom objects/item 11.PNG",DeviceInformation.screenWidth *1465/1920, DeviceInformation.screenHeight *491/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *50/1080);
        createText("Red Mug");
        createButton("images/Classroom images/classroom objects/item 12.PNG", DeviceInformation.screenWidth *1172/1920, DeviceInformation.screenHeight *525/1080,
                DeviceInformation.screenWidth *100/1920, DeviceInformation.screenHeight *30/1080);
        createText("keyBoard");
        createButton("images/Classroom images/classroom objects/item 13.PNG", DeviceInformation.screenWidth *1314/1920, DeviceInformation.screenHeight *581/1080,
                DeviceInformation.screenWidth *80/1920, DeviceInformation.screenHeight *35/1080);
        createText("Kitkat");
        createButton("images/Classroom images/classroom objects/item 14.PNG", DeviceInformation.screenWidth *1199/1920, DeviceInformation.screenHeight *485/1080,
                DeviceInformation.screenWidth *70/1920, DeviceInformation.screenHeight *30/1080);
        createText("Diary");
        createButton("images/Classroom images/classroom objects/item 15.PNG",DeviceInformation.screenWidth *1308/1920, DeviceInformation.screenHeight *445/1080,
                DeviceInformation.screenWidth *50/1920, DeviceInformation.screenHeight *20/1080);
        createText("Banana");
        createButton("images/Classroom images/classroom objects/item 16.PNG", DeviceInformation.screenWidth *1319/1920, DeviceInformation.screenHeight *417/1080,
                DeviceInformation.screenWidth *30/1920, DeviceInformation.screenHeight *30/1080);
        createText("Among us");
        createButton("images/Classroom images/classroom objects/item 17.PNG", DeviceInformation.screenWidth *1172/1920, DeviceInformation.screenHeight *410/1080,
                DeviceInformation.screenWidth *40/1920, DeviceInformation.screenHeight *50/1080);
        createText("Paper Packet");
        createButton("images/Classroom images/classroom objects/item 18.PNG", DeviceInformation.screenWidth *1087/1920, DeviceInformation.screenHeight *399/1080,
                DeviceInformation.screenWidth *20/1920, DeviceInformation.screenHeight *60/1080);
        createText("Coca Cola bottle");
        createButton("images/Classroom images/classroom objects/item 19.PNG", DeviceInformation.screenWidth *1186/1920, DeviceInformation.screenHeight *204/1080,
                DeviceInformation.screenWidth *30/1920, DeviceInformation.screenHeight *190/1080);
        createText("Side Bag");
        createButton("images/Classroom images/classroom objects/item 20.PNG",DeviceInformation.screenWidth *1041/1920, DeviceInformation.screenHeight *237/1080,
                DeviceInformation.screenWidth *55/1920, DeviceInformation.screenHeight *60/1080);
        createText("Painting");






        createButton("images/Classroom images/classroom objects/item 21.PNG", DeviceInformation.screenWidth *677/1920, DeviceInformation.screenHeight *9/1080,
                DeviceInformation.screenWidth *70/1920, DeviceInformation.screenHeight *80/1080);
        createText("Clock");
        createButton("images/Classroom images/classroom objects/item 22.PNG",  DeviceInformation.screenWidth *0/1920, DeviceInformation.screenHeight *110/1080,
                DeviceInformation.screenWidth *115/1920, DeviceInformation.screenHeight *200/1080);
        createText("Calendar");
        createButton("images/Classroom images/classroom objects/item 23.PNG",  DeviceInformation.screenWidth *1438/1920, DeviceInformation.screenHeight *908/1080,
                DeviceInformation.screenWidth *60/1920, DeviceInformation.screenHeight *60/1080);
        createText("Wallet");
        createButton("images/Classroom images/classroom objects/item 24.PNG",  DeviceInformation.screenWidth *1508/1920, DeviceInformation.screenHeight *858/1080,
                DeviceInformation.screenWidth *150/1920, DeviceInformation.screenHeight *160/1080);
        createText("Nike Bag");
        createButton("images/Classroom images/classroom objects/item 25.PNG",  DeviceInformation.screenWidth *1468/1920, DeviceInformation.screenHeight *791/1080,
                DeviceInformation.screenWidth *65/1920, DeviceInformation.screenHeight *60/1080);
        createText("Cap");
        createButton("images/Classroom images/classroom objects/item 26.PNG", DeviceInformation.screenWidth *1303/1920, DeviceInformation.screenHeight *763/1080,
                DeviceInformation.screenWidth *55/1920, DeviceInformation.screenHeight *30/1080);
        createText("Hershey's");
        createButton("images/Classroom images/classroom objects/item 27.PNG",  DeviceInformation.screenWidth *1202/1920, DeviceInformation.screenHeight *608/1080,
                DeviceInformation.screenWidth *95/1920, DeviceInformation.screenHeight *40/1080);
        createText("Neck Pillow");
        createButton("images/Classroom images/classroom objects/item 28.PNG",  DeviceInformation.screenWidth *1086/1920, DeviceInformation.screenHeight *480/1080,
                DeviceInformation.screenWidth *20/1920, DeviceInformation.screenHeight *40/1080);
        createText("Duck");
        createButton("images/Classroom images/classroom objects/item 29.PNG",  DeviceInformation.screenWidth *1009/1920, DeviceInformation.screenHeight *493/1080,
                DeviceInformation.screenWidth *45/1920, DeviceInformation.screenHeight *40/1080);
        createText("<html>Black and white <br/> Box on table </html>");
        createButton("images/Classroom images/classroom objects/item 30.PNG",  DeviceInformation.screenWidth *1010/1920, DeviceInformation.screenHeight *453/1080,
                DeviceInformation.screenWidth *75/1920, DeviceInformation.screenHeight *40/1080);
        createText("Mango Juice");





        createButton("images/Classroom images/classroom objects/item 31.PNG",   DeviceInformation.screenWidth *892/1920, DeviceInformation.screenHeight *426/1080,
                DeviceInformation.screenWidth *35/1920, DeviceInformation.screenHeight *40/1080);
        createText("Cards");
        createButton("images/Classroom images/classroom objects/item 32.PNG",  DeviceInformation.screenWidth *741/1920, DeviceInformation.screenHeight *543/1080,
                DeviceInformation.screenWidth *45/1920, DeviceInformation.screenHeight *30/1080);
        createText("Donuts");
        createButton("images/Classroom images/classroom objects/item 33.PNG",   DeviceInformation.screenWidth *777/1920, DeviceInformation.screenHeight *485/1080,
                DeviceInformation.screenWidth *125/1920, DeviceInformation.screenHeight *25/1080);
        createText("Open Diary");
        createButton("images/Classroom images/classroom objects/item 34.PNG",   DeviceInformation.screenWidth *786/1920, DeviceInformation.screenHeight *420/1080,
                DeviceInformation.screenWidth *30/1920, DeviceInformation.screenHeight *35/1080);
        createText("<html>kirby</html>");
        createButton("images/Classroom images/classroom objects/item 35.PNG",   DeviceInformation.screenWidth *711/1920, DeviceInformation.screenHeight *450/1080,
                DeviceInformation.screenWidth *35/1920, DeviceInformation.screenHeight *50/1080);
        createText("Pikachu");
        createButton("images/Classroom images/classroom objects/item 36.PNG",   DeviceInformation.screenWidth *543/1920, DeviceInformation.screenHeight *527/1080,
                DeviceInformation.screenWidth *60/1920, DeviceInformation.screenHeight *28/1080);
        createText("Pink Book");
        createButton("images/Classroom images/classroom objects/item 37.PNG",   DeviceInformation.screenWidth *1011/1920, DeviceInformation.screenHeight *607/1080,
                DeviceInformation.screenWidth *35/1920, DeviceInformation.screenHeight *30/1080);
        createText("Dice");
        createButton("images/Classroom images/classroom objects/item 38.PNG",   DeviceInformation.screenWidth *1028/1920, DeviceInformation.screenHeight *750/1080,
                DeviceInformation.screenWidth *75/1920, DeviceInformation.screenHeight *45/1080);
        createText("Sock");
        createButton("images/Classroom images/classroom objects/item 39.PNG",   DeviceInformation.screenWidth *1135/1920, DeviceInformation.screenHeight *791/1080,
                DeviceInformation.screenWidth *80/1920, DeviceInformation.screenHeight *60/1080);
        createText("Timer");



        createButton("images/Classroom images/classroom objects/item 40.PNG",  DeviceInformation.screenWidth *1046/1920, DeviceInformation.screenHeight *897/1080,
                DeviceInformation.screenWidth *45/1920, DeviceInformation.screenHeight *55/1080);
        createText("<html>Music <br/> player </html>");
        createButton("images/Classroom images/classroom objects/item 41.PNG", DeviceInformation.screenWidth *132/1920, DeviceInformation.screenHeight *423/1080,
                DeviceInformation.screenWidth *45/1920, DeviceInformation.screenHeight *55/1080);
        createText("Closed Paper Bag");
        createButton("images/Classroom images/classroom objects/item 42.PNG", DeviceInformation.screenWidth *490/1920, DeviceInformation.screenHeight *428/1080,
                DeviceInformation.screenWidth *35/1920, DeviceInformation.screenHeight *40/1080);
        createText("Mug");
        createButton("images/Classroom images/classroom objects/item 43.PNG", DeviceInformation.screenWidth *417/1920, DeviceInformation.screenHeight *456/1080,
                DeviceInformation.screenWidth *44/1920, DeviceInformation.screenHeight *60/1080);
        createText("<html>Jenga<br/> tower </html>");
        createButton("images/Classroom images/classroom objects/item 45.PNG", DeviceInformation.screenWidth *876/1920, DeviceInformation.screenHeight *711/1080,
                DeviceInformation.screenWidth *125/1920, DeviceInformation.screenHeight *33/1080);
        createText("Puzzle");
        createButton("images/Classroom images/classroom objects/item 46.PNG", DeviceInformation.screenWidth *335/1920, DeviceInformation.screenHeight *715/1080,
                DeviceInformation.screenWidth *140/1920, DeviceInformation.screenHeight *85/1080);
        createText("Stack of Books");
        createButton("images/Classroom images/classroom objects/item 47.PNG", DeviceInformation.screenWidth *681/1920, DeviceInformation.screenHeight *888/1080,
                DeviceInformation.screenWidth *60/1920, DeviceInformation.screenHeight *30/1080);
        createText("Yellow Box");
        createButton("images/Classroom images/classroom objects/item 48.PNG", DeviceInformation.screenWidth *381/1920, DeviceInformation.screenHeight *922/1080,
                DeviceInformation.screenWidth *90/1920, DeviceInformation.screenHeight *40/1080);
        createText("Uno Card");
        createButton("images/Classroom images/classroom objects/item 49.PNG", DeviceInformation.screenWidth *195/1920, DeviceInformation.screenHeight *820/1080,
                DeviceInformation.screenWidth *155/1920, DeviceInformation.screenHeight *80/1080);
        createText("Chess Board");
        createButton("images/Classroom images/classroom objects/item 50.PNG", DeviceInformation.screenWidth *70/1920, DeviceInformation.screenHeight *730/1080,
                DeviceInformation.screenWidth *95/1920, DeviceInformation.screenHeight *90/1080);
        createText("FootBall");




        createButton("images/Classroom images/classroom objects/item 51.PNG",  DeviceInformation.screenWidth *180/1920, DeviceInformation.screenHeight *642/1080,
                DeviceInformation.screenWidth *32/1920, DeviceInformation.screenHeight *78/1080);
        createText("Red Bull Can ");
        createButton("images/Classroom images/classroom objects/item 52.PNG",  DeviceInformation.screenWidth *129/1920, DeviceInformation.screenHeight *486/1080,
                DeviceInformation.screenWidth *155/1920, DeviceInformation.screenHeight *140/1080);
        createText("Pizza Box");
        createButton("images/Classroom images/classroom objects/item 53.PNG",  DeviceInformation.screenWidth *315/1920, DeviceInformation.screenHeight *475/1080,
                DeviceInformation.screenWidth *85/1920, DeviceInformation.screenHeight *90/1080);
        createText("Shopping Bag");
        createButton("images/Classroom images/classroom objects/item 54.PNG",  DeviceInformation.screenWidth *482/1920, DeviceInformation.screenHeight *583/1080,
                DeviceInformation.screenWidth *75/1920, DeviceInformation.screenHeight *20/1080);
        createText("Scissors");
        createButton("images/Classroom images/classroom objects/item 55.PNG",  DeviceInformation.screenWidth *532/1920, DeviceInformation.screenHeight *596/1080,
                DeviceInformation.screenWidth *120/1920, DeviceInformation.screenHeight *70/1080);
        createText("Stack of books");
        createButton("images/Classroom images/classroom objects/item 56.PNG",  DeviceInformation.screenWidth *403/1920, DeviceInformation.screenHeight *643/1080,
                DeviceInformation.screenWidth *75/1920, DeviceInformation.screenHeight *20/1080);
        createText("Tab");
        createButton("images/Classroom images/classroom objects/item 57.PNG",  DeviceInformation.screenWidth *664/1920, DeviceInformation.screenHeight *619/1080,
                DeviceInformation.screenWidth *85/1920, DeviceInformation.screenHeight *40/1080);
        createText("File");
        createButton("images/Classroom images/classroom objects/item 59.PNG",  DeviceInformation.screenWidth *67/1920, DeviceInformation.screenHeight *529/1080,
                DeviceInformation.screenWidth *45/1920, DeviceInformation.screenHeight *50/1080);
        createText("Uno Reverse");

        this.add(backgroundLabel);
    }

}

