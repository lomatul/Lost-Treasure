package src.levels;

import src.setup.DeviceInformation;

import javax.swing.*;
import java.io.IOException;

public class LibrarySceneT extends ALevelPanel {
    public LibrarySceneT(JFrame jFrame){
        super(jFrame);
    }
    @Override
    public int getLevelNumber() {
        return 4;
    }
    @Override
    public String getBackgroundPath() {
        return "images/libraryImages/libraryMain.png";
    }

    @Override
    public String getBackgroundMusicPath() {
        return "audio/background_music/libraryBackgroundAudio.wav";
    }

    @Override
    public String getMessMessage(){
        return "<html>Why is everywhere so messy?<br/>Time to start searching (Tap to Search)</html>";
    }

    @Override
    public synchronized void generateScreenWithAllObjectsAndButtons() throws IOException {
        createButton("images/libraryImages/levelTwoWithOutlines/item 0.PNG", DeviceInformation.screenWidth *308/1536, DeviceInformation.screenHeight *741/864,
                DeviceInformation.screenWidth *45/1536, DeviceInformation.screenHeight *10/864);
        createText("<html>Black and white <br/> Photo </html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 1.PNG", DeviceInformation.screenWidth *840/1536, DeviceInformation.screenHeight *484/864,
                DeviceInformation.screenWidth *60/1536, DeviceInformation.screenHeight *9/864);
        createText("<html>A piece of paper<br/> on table</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 2.PNG", DeviceInformation.screenWidth *820/1536, DeviceInformation.screenHeight *490/864,
                DeviceInformation.screenWidth *18/1536, DeviceInformation.screenHeight *12/864);
        createText(" Red Mouse");
        createButton("images/libraryImages/levelTwoWithOutlines/item 3.PNG", DeviceInformation.screenWidth *528/1536, DeviceInformation.screenHeight *662/864,
                DeviceInformation.screenWidth *25/1536, DeviceInformation.screenHeight *8/864);
        createText("keys");
        createButton("images/libraryImages/levelTwoWithOutlines/item 4.PNG", DeviceInformation.screenWidth *10/1536, DeviceInformation.screenHeight *745/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *22/864);
        createText("Red bundle");
        createButton("images/libraryImages/levelTwoWithOutlines/item 5.PNG", DeviceInformation.screenWidth *590/1536, DeviceInformation.screenHeight *718/864,
                DeviceInformation.screenWidth *75/1536, DeviceInformation.screenHeight *60/864);
        createText("<html> Green  Apple Juice<br/> on </html>");
       createButton("images/libraryImages/levelTwoWithOutlines/item 6.PNG", DeviceInformation.screenWidth *200/1536, DeviceInformation.screenHeight *728/864,
                DeviceInformation.screenWidth *78/1536, DeviceInformation.screenHeight *25/864);
        createText("Open Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 7.PNG", DeviceInformation.screenWidth *228/1536, DeviceInformation.screenHeight *570/864,
                DeviceInformation.screenWidth *10/1536, DeviceInformation.screenHeight *10/864);
        createText("Wrist Watch");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 8.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 9.PNG", DeviceInformation.screenWidth *970/1536, DeviceInformation.screenHeight *458/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *35/864);
        createText("Stack of books");
        createButton("images/libraryImages/levelTwoWithOutlines/item 10.PNG", DeviceInformation.screenWidth *108/1536, DeviceInformation.screenHeight *588/864,
                DeviceInformation.screenWidth *88/1536, DeviceInformation.screenHeight *28/864);
        createText("Soft Drinks");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 11.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 12.PNG", DeviceInformation.screenWidth *795/1536, DeviceInformation.screenHeight *744/864,
                DeviceInformation.screenWidth *20/1536, DeviceInformation.screenHeight *12/864);
        createText("<html>keyring on the <br/> floor<html>");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 13.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 14.PNG", DeviceInformation.screenWidth *1078/1536, DeviceInformation.screenHeight *748/864,
                DeviceInformation.screenWidth *80/1536, DeviceInformation.screenHeight *15/864);
        createText("NotePad");
        createButton("images/libraryImages/levelTwoWithOutlines/item 15.PNG", DeviceInformation.screenWidth *1068/1536, DeviceInformation.screenHeight *472/864,
                DeviceInformation.screenWidth *20/1536, DeviceInformation.screenHeight *10/864);
        createText("wallet");
        createButton("images/libraryImages/levelTwoWithOutlines/item 16.PNG", DeviceInformation.screenWidth *282/1536, DeviceInformation.screenHeight *507/864,
                DeviceInformation.screenWidth *10/1536, DeviceInformation.screenHeight *10/864);
        createText("FirstAid kit");
        createButton("images/libraryImages/levelTwoWithOutlines/item 17.PNG", DeviceInformation.screenWidth *578/1536, DeviceInformation.screenHeight *42/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *74/864);
        createText("Wall Clock");
        createButton("images/libraryImages/levelTwoWithOutlines/item 18.PNG", DeviceInformation.screenWidth *121/1536, DeviceInformation.screenHeight *182/864,
                DeviceInformation.screenWidth *16/1536, DeviceInformation.screenHeight *22/864);
        createText("Clock");
        createButton("images/libraryImages/levelTwoWithOutlines/item 19.PNG", DeviceInformation.screenWidth *927/1536, DeviceInformation.screenHeight *228/864,
                DeviceInformation.screenWidth *26/1536, DeviceInformation.screenHeight *25/864);
        createText("<html>Database System <br/> book  on shelve </html>");





        createButton("images/libraryImages/levelTwoWithOutlines/item 20.PNG", DeviceInformation.screenWidth *914/1536, DeviceInformation.screenHeight *434/864,
                DeviceInformation.screenWidth *40/1536, DeviceInformation.screenHeight *15/864);
        createText("black Diary");
        createButton("images/libraryImages/levelTwoWithOutlines/item 21.PNG", DeviceInformation.screenWidth *431/1536, DeviceInformation.screenHeight *486/864,
                DeviceInformation.screenWidth *50/1536, DeviceInformation.screenHeight *5/864);
        createText("<html> white Paper <br/> on table </html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 22.PNG", DeviceInformation.screenWidth *955/1536, DeviceInformation.screenHeight *608/864,
                DeviceInformation.screenWidth *70/1536, DeviceInformation.screenHeight *35/864);
        createText("Board");

        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 23.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 24.PNG", DeviceInformation.screenWidth *308/1536, DeviceInformation.screenHeight *437/864,
                DeviceInformation.screenWidth *120/1536, DeviceInformation.screenHeight *95/864);
        createText("Laptop");
        createButton("images/libraryImages/levelTwoWithOutlines/item 25.PNG", DeviceInformation.screenWidth *817/1536, DeviceInformation.screenHeight *381/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *70/864);
        createText("Laptop Screen");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 26.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 27.PNG", DeviceInformation.screenWidth *888/1536, DeviceInformation.screenHeight *410/864,
                DeviceInformation.screenWidth *20/1536, DeviceInformation.screenHeight *40/864);
        createText("Coffee Cup");
        createButton("images/libraryImages/levelTwoWithOutlines/item 28.PNG", DeviceInformation.screenWidth *818/1536, DeviceInformation.screenHeight *500/864,
                DeviceInformation.screenWidth *85/1536, DeviceInformation.screenHeight *45/864);
        createText("<html>Stack of <br/> White paper </html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 29.PNG", DeviceInformation.screenWidth *752/1536, DeviceInformation.screenHeight *455/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *32/864);
        createText("<html>Stack of <br/> 3 books </html>");




        createButton("images/libraryImages/levelTwoWithOutlines/item 30.PNG", DeviceInformation.screenWidth *1064/1536, DeviceInformation.screenHeight *505/864,
                DeviceInformation.screenWidth *78/1536, DeviceInformation.screenHeight *18/864);
        createText("White Charger");
        createButton("images/libraryImages/levelTwoWithOutlines/item 31.PNG", DeviceInformation.screenWidth *978/1536, DeviceInformation.screenHeight *510/864,
                DeviceInformation.screenWidth *18/1536, DeviceInformation.screenHeight *15/864);
        createText("Black mouse");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 32.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 33.PNG", DeviceInformation.screenWidth *1085/1536, DeviceInformation.screenHeight *443/864,
                DeviceInformation.screenWidth *58/1536, DeviceInformation.screenHeight *65/864);
        createText("Shoulder Bag");
        createButton("images/libraryImages/levelTwoWithOutlines/item 34.PNG", DeviceInformation.screenWidth *1146/1536, DeviceInformation.screenHeight *541/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *35/864);
        createText("Pizza Box");
        createButton("images/libraryImages/levelTwoWithOutlines/item 35.PNG", DeviceInformation.screenWidth *1023/1536, DeviceInformation.screenHeight *642/864,
                DeviceInformation.screenWidth *128/1536, DeviceInformation.screenHeight *62/864);
        createText("letters");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 36.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 37.PNG", DeviceInformation.screenWidth *1276/1536, DeviceInformation.screenHeight *644/864,
                DeviceInformation.screenWidth *38/1536, DeviceInformation.screenHeight *55/864);
        createText("Watch");
        createButton("images/libraryImages/levelTwoWithOutlines/item 38.PNG", DeviceInformation.screenWidth *1158/1536, DeviceInformation.screenHeight *492/864,
                DeviceInformation.screenWidth *20/1536, DeviceInformation.screenHeight *62/864);
        createText("<html>Apple Juice <br/> in the shelves </html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 39.PNG", DeviceInformation.screenWidth *950/1536, DeviceInformation.screenHeight *669/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *28/864);
        createText("PowerBank");


        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 40.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 40.PNG", DeviceInformation.screenWidth *1025/1536, DeviceInformation.screenHeight *495/864,
                DeviceInformation.screenWidth *38/1536, DeviceInformation.screenHeight *15/864);
        createText("Cornflakes Box");
        createButton("images/libraryImages/levelTwoWithOutlines/item 41.PNG", DeviceInformation.screenWidth *993/1536, DeviceInformation.screenHeight *633/864,
                DeviceInformation.screenWidth *44/1536, DeviceInformation.screenHeight *42/864);
        createText("Earbud case");
        createButton("images/libraryImages/levelTwoWithOutlines/item 42.PNG", DeviceInformation.screenWidth *1158/1536, DeviceInformation.screenHeight *728/864,
                DeviceInformation.screenWidth *53/1536, DeviceInformation.screenHeight *47/864);
        createText("Biscuits");
        createButton("images/libraryImages/levelTwoWithOutlines/item 43.PNG", DeviceInformation.screenWidth *1494/1536, DeviceInformation.screenHeight *135/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *35/864);
        createText("<html>Automata Theory<br/> book over the shelve</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 44.PNG", DeviceInformation.screenWidth *886/1536, DeviceInformation.screenHeight *392/864,
                DeviceInformation.screenWidth *30/1536, DeviceInformation.screenHeight *20/864);
        createText("Clean Code Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 45.PNG", DeviceInformation.screenWidth *186/1536, DeviceInformation.screenHeight *219/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *40/864);
        createText("<html>Clean code BOOK<br/> in the shelves</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 46.PNG", DeviceInformation.screenWidth *1455/1536, DeviceInformation.screenHeight *366/864,
                DeviceInformation.screenWidth *72/1536, DeviceInformation.screenHeight *55/864);
        createText("Linear Algebra Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 47.PNG", DeviceInformation.screenWidth *1250/1536, DeviceInformation.screenHeight *172/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *65/864);
        createText("Database System Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 48.PNG", DeviceInformation.screenWidth *934/1536, DeviceInformation.screenHeight *472/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *30/864);
        createText("Camera");
        createButton("images/libraryImages/levelTwoWithOutlines/item 49.PNG", DeviceInformation.screenWidth *161/1536, DeviceInformation.screenHeight *218/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *35/864);
        createText("Linear Algebra Book");


        createButton("images/libraryImages/levelTwoWithOutlines/item 50.PNG", DeviceInformation.screenWidth *167/1536, DeviceInformation.screenHeight *618/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *25/864);
        createText("Open Diary");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 51.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 52.PNG", DeviceInformation.screenWidth *294/1536, DeviceInformation.screenHeight *618/864,
                DeviceInformation.screenWidth *58/1536, DeviceInformation.screenHeight *25/864);
        createText("Bag");
        createButton("images/libraryImages/levelTwoWithOutlines/item 53.PNG", DeviceInformation.screenWidth *818/1536, DeviceInformation.screenHeight *213/864,
                DeviceInformation.screenWidth *34/1536, DeviceInformation.screenHeight *45/864);
        createText("<html>Java Book <br/> on the shelves</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 54.PNG", DeviceInformation.screenWidth *86/1536, DeviceInformation.screenHeight *704/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *60/864);
        createText("Orange Cup");
        createButton("images/libraryImages/levelTwoWithOutlines/item 55.PNG", DeviceInformation.screenWidth /1536, DeviceInformation.screenHeight *680/864,
                DeviceInformation.screenWidth *78/1536, DeviceInformation.screenHeight *50/864);
        createText("Chips Packet");
        createButton("images/libraryImages/levelTwoWithOutlines/item 56.PNG", DeviceInformation.screenWidth *82/1536, DeviceInformation.screenHeight *570/864,
                DeviceInformation.screenWidth *24/1536, DeviceInformation.screenHeight *25/864);
        createText("Brown Glass");
        createButton("images/libraryImages/levelTwoWithOutlines/item 57.PNG", DeviceInformation.screenWidth *30/1536, DeviceInformation.screenHeight *615/864,
                DeviceInformation.screenWidth *35/1536, DeviceInformation.screenHeight *25/864);
        createText("Spectacles");
        createButton("images/libraryImages/levelTwoWithOutlines/item 58.PNG", DeviceInformation.screenWidth *26/1536, DeviceInformation.screenHeight *564/864,
                DeviceInformation.screenWidth *27/1536, DeviceInformation.screenHeight *32/864);
        createText("Destroyed Can");
        createButton("images/libraryImages/levelTwoWithOutlines/item 59.PNG", DeviceInformation.screenWidth *226/1536, DeviceInformation.screenHeight *382/864,
                DeviceInformation.screenWidth *18/1536, DeviceInformation.screenHeight *45/864);
        createText("Coke Bottle");
        createButton("images/libraryImages/levelTwoWithOutlines/item 60.PNG", 0 /1536, DeviceInformation.screenHeight *419/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *25/864);
        createText("<html>Database Management Book<br/> on the table </html>");



        createButton("images/libraryImages/levelTwoWithOutlines/item 61.PNG", DeviceInformation.screenWidth *132/1536, DeviceInformation.screenHeight *419/864,
                DeviceInformation.screenWidth *55/1536, DeviceInformation.screenHeight *33/864);
        createText("HeadPhone");
        createButton("images/libraryImages/levelTwoWithOutlines/item 62.PNG", DeviceInformation.screenWidth *197/1536, DeviceInformation.screenHeight *409/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *25/864);
        createText("Charger");
        createButton("images/libraryImages/levelTwoWithOutlines/item 64.PNG", DeviceInformation.screenWidth *382/1536, DeviceInformation.screenHeight *393/864,
                DeviceInformation.screenWidth *55/1536, DeviceInformation.screenHeight *65/864);
        createText("White Board");
        createButton("images/libraryImages/levelTwoWithOutlines/item 65.PNG", DeviceInformation.screenWidth *388/1536, DeviceInformation.screenHeight *222/864,
                DeviceInformation.screenWidth *26/1536, DeviceInformation.screenHeight *29/864);
        createText("<html>Red Automata <br/> Theory Book</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 66.PNG", DeviceInformation.screenWidth *322/1536, DeviceInformation.screenHeight *365/864,
                DeviceInformation.screenWidth *42/1536, DeviceInformation.screenHeight *45/864);
        createText("Tab");
        createButton("images/libraryImages/levelTwoWithOutlines/item 68.PNG", DeviceInformation.screenWidth *474/1536, DeviceInformation.screenHeight *218/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *40/864);
        createText("Clean Code Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 69.PNG", DeviceInformation.screenWidth *1233/1536, DeviceInformation.screenHeight *688/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *19/864);
        createText("StopWatch");
        createButton("images/libraryImages/levelTwoWithOutlines/item 70.PNG", DeviceInformation.screenWidth *874/1536, DeviceInformation.screenHeight *370/864,
                DeviceInformation.screenWidth *20/1536, DeviceInformation.screenHeight *29/864);
        createText("<html>Coffee cup<br/>on the table </html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 72.PNG", DeviceInformation.screenWidth *965/1536, DeviceInformation.screenHeight *235/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *75/864);
        createText("Calendar");
        createButton("images/libraryImages/levelTwoWithOutlines/item 74.PNG", DeviceInformation.screenWidth *1035/1536, DeviceInformation.screenHeight *213/864,
                DeviceInformation.screenWidth *35/1536, DeviceInformation.screenHeight *42/864);
        createText("<html>Linear Algebra<br/> on the shelves</html>");
        createButton("images/libraryImages/levelTwoWithOutlines/item 75.PNG", DeviceInformation.screenWidth *854/1536, DeviceInformation.screenHeight *710/864,
                DeviceInformation.screenWidth *38/1536, DeviceInformation.screenHeight *65/864);
        createText("Noodles");
        createButton("images/libraryImages/levelTwoWithOutlines/item 77.PNG", DeviceInformation.screenWidth *1165/1536, DeviceInformation.screenHeight *586/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *25/864);
        createText("Black Mug");
        createButton("images/libraryImages/levelTwoWithOutlines/item 78.PNG", DeviceInformation.screenWidth *1350/1536, DeviceInformation.screenHeight *682/864,
                DeviceInformation.screenWidth *58/1536, DeviceInformation.screenHeight *75/864);
        createText(" Box");
        createLabelOnly("images/libraryImages/levelTwoWithOutlines/item 79.PNG");
        createButton("images/libraryImages/levelTwoWithOutlines/item 80.PNG", DeviceInformation.screenWidth *925/1536, DeviceInformation.screenHeight *574/864,
                DeviceInformation.screenWidth *35/1536, DeviceInformation.screenHeight *23/864);
        createText("NewsPaper");
        createButton("images/libraryImages/levelTwoWithOutlines/item 81.PNG", DeviceInformation.screenWidth *929/1536, DeviceInformation.screenHeight *746/864,
                DeviceInformation.screenWidth *78/1536, DeviceInformation.screenHeight *20/864);
        createText(" White Wrist watch");
        createButton("images/libraryImages/levelTwoWithOutlines/item 82.PNG", DeviceInformation.screenWidth *958/1536, DeviceInformation.screenHeight *588/864,
                DeviceInformation.screenWidth *48/1536, DeviceInformation.screenHeight *25/864);
        createText("Diary");
        createButton("images/libraryImages/levelTwoWithOutlines/item 83.PNG", DeviceInformation.screenWidth *1044/1536, DeviceInformation.screenHeight *557/864,
                DeviceInformation.screenWidth *78/1536, DeviceInformation.screenHeight *35/864);
        createText("Crayons Box");
        createButton("images/libraryImages/levelTwoWithOutlines/item 84.PNG", DeviceInformation.screenWidth *1041/1536, DeviceInformation.screenHeight *515/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *25/864);
        createText("Closed Diary");
        createButton("images/libraryImages/levelTwoWithOutlines/item 85.PNG", DeviceInformation.screenWidth *1126/1536, DeviceInformation.screenHeight *612/864,
                DeviceInformation.screenWidth *28/1536, DeviceInformation.screenHeight *35/864);
        createText("Coffee Cup");
        createButton("images/libraryImages/levelTwoWithOutlines/item 86.PNG", DeviceInformation.screenWidth *954/1536, DeviceInformation.screenHeight *705/864,
                DeviceInformation.screenWidth *68/1536, DeviceInformation.screenHeight *25/864);
        createText("Script");
        createButton("images/libraryImages/levelTwoWithOutlines/item 87.PNG", DeviceInformation.screenWidth *1448/1536, DeviceInformation.screenHeight *710/864,
                DeviceInformation.screenWidth *74/1536, DeviceInformation.screenHeight *18/864);
        createText("Diary");
        createButton("images/libraryImages/levelTwoWithOutlines/item 88.PNG", DeviceInformation.screenWidth *1062/1536, DeviceInformation.screenHeight *711/864,
                DeviceInformation.screenWidth *60/1536, DeviceInformation.screenHeight *12/864);
        createText("Paper PLane");
        createButton("images/libraryImages/levelTwoWithOutlines/item 89.PNG", DeviceInformation.screenWidth *1235/1536, DeviceInformation.screenHeight *718/864,
                DeviceInformation.screenWidth *109/1536, DeviceInformation.screenHeight *48/864);
        createText("Jurassic PArk Book");
        createButton("images/libraryImages/levelTwoWithOutlines/item 90.PNG", DeviceInformation.screenWidth *1050/1536, DeviceInformation.screenHeight *606/864,
                DeviceInformation.screenWidth *64/1536, DeviceInformation.screenHeight *22/864);
        createText("A pair of glass");

        this.add(backgroundLabel);
    }

}
