package src.levels;

import src.events.LabelListener;
import src.levelObjects.Sound;
import src.buttons.AudioChangeButton;
import src.buttons.LevelCloseButton;
import src.buttons.ObjectHidingButton;
import src.levelObjects.ScoreBoard;
import src.levelObjects.TimerLabel;
import src.popups.HintConfirmationDialogue;
import src.popups.TimeOverConfirmationDialog;
import src.setup.DeviceInformation;
import src.setup.FontInfo;
import src.setup.RandomGenerator;
import src.transitionPanels.LoadingAnimationT;
import src.transitionPanels.MapT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class ALevelPanel extends JPanel implements Runnable{
    public JFrame jFrame;
    Rectangle maxBounds;
    public int score = 0;
    public int currentCombo = 0;
    public Sound objClickSound;
    public int timeSinceLastFind = 0;
    JLabel backgroundLabel;
    JLabel BigItemListAtBottomOfScreen;
    public LoadingAnimationT loadingAnimationT;
    MapT mapT;
    boolean levelFinished;
    public int imagesFound;
    int textBox_height;
    int level_number;
    JButton messNotification; // notification that someone messed up your dorm room
    RandomGenerator randomGenerator;
    boolean InitiallyClicked = false;
    public TimerLabel timerLabel;
    public ScoreBoard scoreBoard;
    public Sound backgroundMusic;
    public JLabel ShowGottenScore;
    public JLabel hintAnimationGif;
    public JLabel congratulationsConfetti;
    public ArrayList<JLabel> imageList = new ArrayList<>(); // array of images of items we may need to find
    public ArrayList<ObjectHidingButton> buttonList = new ArrayList<>(); //all the buttons for the objects are in this
    public ArrayList<String> textList = new ArrayList<>(); //all the names of the objects are in this\
    public ArrayList<JLabel> ListOfAllItemNamesAsLabels = new ArrayList<>(); //the labels containing Strings of 'item names' that were randomly chosen
    public ArrayList<Integer> RandObjIndices;
    /**change to implement**/
    public int PassingScore = 400;

    public HintConfirmationDialogue hintConfirmationDialogue;
    public TimeOverConfirmationDialog timeOverConfirmationDialog;


    ALevelPanel(JFrame jFrame){
        this.jFrame = jFrame;
        levelFinished = false;
        maxBounds = DeviceInformation.graphicsEnvironment.getMaximumWindowBounds();
        textBox_height = DeviceInformation.screenHeight*50/864;
        this.setLayout(null);

    }

    public void createConfettiScreen(){
        congratulationsConfetti = new JLabel();
        congratulationsConfetti.setBounds(0,0, DeviceInformation.screenWidth,DeviceInformation.screenHeight);
        ImageIcon gif = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/congratulations/levelFinishedSuccessfullyConfetti.gif")));
        gif.setImage(gif.getImage().getScaledInstance(DeviceInformation.screenWidth, DeviceInformation.screenHeight, Image.SCALE_DEFAULT));
        congratulationsConfetti.setIcon(gif);
        congratulationsConfetti.setVisible(false);
        this.add(congratulationsConfetti);
    }

    public JLabel createObject(String image) throws IOException{
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(0,0,maxBounds.width,maxBounds.height-textBox_height);

        ImageIcon  obj1icon= new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(image)));
        obj1icon.setImage(obj1icon.getImage().getScaledInstance(maxBounds.width, maxBounds.height-textBox_height, Image.SCALE_DEFAULT));

        objectLabel.setIcon(obj1icon);
        imageList.add(objectLabel);
        return objectLabel;

    }
    private synchronized void CreateAListWithAllItemNamesAsLabels() {

        for (String s : textList) {
            JLabel temp = new JLabel(s, SwingConstants.CENTER);
            temp.setForeground(Color.white);
            temp.setFont(FontInfo.getResizedFont(37f));
//            temp.setText(textList.get(i));
            ListOfAllItemNamesAsLabels.add(temp);
        }

    }

    public void CreateTheBigItemListTextBoxAtTheBottomOfScreen(){
        BigItemListAtBottomOfScreen = new JLabel();
        BigItemListAtBottomOfScreen.setLayout(new GridLayout(1,5));
        BigItemListAtBottomOfScreen.setBounds(0, DeviceInformation.screenHeight -(textBox_height*2), DeviceInformation.screenWidth, textBox_height*2);
        BigItemListAtBottomOfScreen.setBackground(Color.decode("#14171C"));
        BigItemListAtBottomOfScreen.setForeground(Color.white);
        BigItemListAtBottomOfScreen.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#14171C"),3), BorderFactory.createLineBorder(Color.white,3)));
        BigItemListAtBottomOfScreen.setFont(FontInfo.getResizedFont(32f));
        BigItemListAtBottomOfScreen.setOpaque(true);
    }

    public synchronized void MakeRandomItemListAtBottomOfScreen(){
        CreateAListWithAllItemNamesAsLabels();
        CreateTheBigItemListTextBoxAtTheBottomOfScreen();
        randomGenerator = new RandomGenerator(buttonList.size());
        randomGenerator.createUnique();
        this.RandObjIndices = randomGenerator.RandObjIndices;
        this.add(BigItemListAtBottomOfScreen);
        int index;
        for (Integer randObjIndex : RandObjIndices) {
            index = randObjIndex;
            ListOfAllItemNamesAsLabels.get(index).addMouseListener(new LabelListener(jFrame, this,
                    ListOfAllItemNamesAsLabels.get(index), index));
            BigItemListAtBottomOfScreen.add(ListOfAllItemNamesAsLabels.get(index));
        }

    }


    public void createLabelOnly(String image){
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(0,0,maxBounds.width,maxBounds.height-textBox_height);

        ImageIcon  obj1icon= new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(image)));
        Image image1 = obj1icon.getImage();
        image1 = image1.getScaledInstance(maxBounds.width, maxBounds.height-textBox_height, Image.SCALE_DEFAULT);
        obj1icon = new ImageIcon(image1);

        objectLabel.setIcon(obj1icon);
        objectLabel.setVisible(true);
        this.add(objectLabel);

    }


    public void  createButton(String image,int posx, int posy, int sizex,int sizey) throws IOException {
        JLabel objectLabel = createObject(image);
        ObjectHidingButton objectHidingButton = new ObjectHidingButton(posx,posy,sizex,sizey, imageList.get(imageList.size()-1), this, buttonList.size());
        this.add(objectHidingButton);
        this.add(objectLabel);
        buttonList.add(objectHidingButton);
    }
    public void createText (String text) {
        textList.add(text);
    }
    public abstract int getLevelNumber();

    public void ResetTimerAndScore( int level_number){
        timerLabel.isTimeOver = false;
        if(level_number==5)
        {
            timerLabel.second = 60;
            timerLabel.minute = 0;
        }
        else
        {
            timerLabel.second = 30;
            timerLabel.minute = 2;
        }
        timerLabel.elapsedTime = 0;
        scoreBoard.score=0;
        scoreBoard.setText("0000");
        imagesFound = 0;
        score=0;
        ShowGottenScore.setVisible(false);

    }
    public void addAudioButton(){
        AudioChangeButton audioChangeButton = new AudioChangeButton(jFrame, backgroundMusic);
        this.add(audioChangeButton);
        this.repaint();
        this.revalidate();
    }
    public int getX(int x){
        return DeviceInformation.screenWidth*x/1536;
    }

    public int getY(int y){
        return  DeviceInformation.screenHeight*y/864;
    }

    public abstract void generateScreenWithAllObjectsAndButtons() throws IOException;

    public void StartLevel() { //when clicked from Map, resets some things and starts the scene
        congratulationsConfetti.setVisible(false);
        ShowGottenScore.setVisible(false);

        messNotification.setVisible(true);
        timerLabel.setVisible(false);
        scoreBoard.setVisible(false);
        MakeRandomItemListAtBottomOfScreen();
        InitiallyClicked = false;
        resetVariables();
        ResetTimerAndScore(getLevelNumber());
    }
    public void resetItemNameLabelList() {

        for(int i = 0; i < textList.size(); i++){
            ListOfAllItemNamesAsLabels.get(i).setVisible(true);
            imageList.get(i).setVisible(true);

        }

    }
    public void PrepareForSceneTransition(LoadingAnimationT loadingAnimationT, MapT mapT) {
        this.loadingAnimationT = loadingAnimationT;
        this.mapT = mapT;
    }
    public void EndLevel() {
        resetItemNameLabelList();
        remove(BigItemListAtBottomOfScreen);

        timerLabel.st_alpha=255;
        if(backgroundMusic != null){
            backgroundMusic.stop();
        }
//        HintAnimationGif.setVisible();
        revalidate();
        repaint();

        jFrame.remove(this);

        loadingAnimationT.changeNextScene(mapT);
        loadingAnimationT.calledBy = getLevelNumber() - 2; //sending my serial so loading can remove the panel and call garbage
        loadingAnimationT.iNeedYouToRemoveMe = true;

//        mapT.MaxDormScore = Math.max(scoreBoard.score, mapT.MaxDormScore);
//        mapT.updateScore();

        jFrame.add(loadingAnimationT);
        loadingAnimationT.initializeTimer();
    }
    public abstract String getBackgroundPath();
    public abstract String getBackgroundMusicPath();
    public void buildScene() throws IOException {
        createConfettiScreen();
        MessNotification();
        setupShowGottenScore();
        setupHintAnimationGif();
        createBackground(getBackgroundPath());

        backgroundMusic = new Sound();
        backgroundMusic.setFile(getBackgroundMusicPath());

        objClickSound = new Sound();
        objClickSound.setFile("audio/soundeffects/objectFoundClick2.wav");



        addCustomWindowCloseButton();
        addAudioButton();
        timerLabel = new TimerLabel(jFrame, this);
        timerLabel.setVisible(false);
        revalidate();

        repaint();
        scoreBoard = new ScoreBoard(jFrame, this);
        scoreBoard.setVisible(false);
        revalidate();
        repaint();

        repaint();

        imagesFound=0;
        generateScreenWithAllObjectsAndButtons();

        repaint();

    }

    private void setupHintAnimationGif() {

        int sizeX = 200;
        int sizeY = 200;

        ImageIcon gif = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Gifs/sparkles.gif")));
        gif.setImage(gif.getImage().getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT));
        hintAnimationGif = new JLabel();
        hintAnimationGif.setBounds(600,500, sizeX,sizeY);

        hintAnimationGif.setIcon(gif);
        hintAnimationGif.setVisible(false);
        this.add(hintAnimationGif);
    }

    private void setupShowGottenScore() {
        ShowGottenScore = new JLabel("", SwingConstants.CENTER);
        ShowGottenScore.setBounds(500,400, 150, 60);
        ShowGottenScore.setBackground(null);
        ShowGottenScore.setFont(FontInfo.getResizedFont(52f));
//        ShowGottenScore.setForeground(new Color(30, 120, 20));
//        ShowGottenScore.setForeground(new Color(255,0,0));
        ShowGottenScore.setVisible(false);
        ShowGottenScore.setOpaque(false);
        this.add(ShowGottenScore);
    }

    public abstract String getMessMessage();

    public void MessNotification(){
        messNotification = new JButton(getMessMessage());
        messNotification.setFont(FontInfo.getResizedFont(38f));
        messNotification.setFocusPainted(false);
        messNotification.setEnabled(false);
        messNotification.setBounds(0, DeviceInformation.screenHeight -(textBox_height*2), DeviceInformation.screenWidth, textBox_height*2);
        messNotification.setBackground(Color.decode("#14171C"));
        messNotification.setForeground(Color.white);
        messNotification.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#14171C"),3), BorderFactory.createLineBorder(Color.white,3)));
        messNotification.setOpaque(true);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                PanelClick();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(messNotification);
    }

    public void PanelClick(){
        if(!InitiallyClicked) {
            timerLabel.setVisible(true);
            scoreBoard.setVisible(true);
            revalidate();
            backgroundMusic.play();
            backgroundMusic.loop();
            repaint();
            enableObjectButtons();
            messNotification.setVisible(false);
            timerLabel.StartTimer();
            InitiallyClicked = true;
        }
    }

    public void enableObjectButtons(){
        for(int i=0; i<6; i++){
            buttonList.get(RandObjIndices.get(i)).setEnabled(true);
        }
    }

    public  void createBackground(String bgfilename) throws IOException {
        this.setLayout(null);
        this.setBounds(0, 0, maxBounds.width, maxBounds.height);//size of the background image
        this.setBackground(Color.black);

        BufferedImage bufferedImage = ImageIO.read(new File(bgfilename));
        Image image = bufferedImage.getScaledInstance(maxBounds.width, maxBounds.height-textBox_height, Image.SCALE_DEFAULT);//        imageIcon = new ImageIcon(image);
        ImageIcon imageIcon = new ImageIcon(image);
//        imageIcon.setImage(imageIcon.getImage().getScaledInstance(maxBounds.width, maxBounds.height-textBox_height, Image.SCALE_DEFAULT));
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0,0, maxBounds.width,maxBounds.height-textBox_height);
        backgroundLabel.setIcon(imageIcon);
    }


    @Override
    public void run(){
        try {
            buildScene();

        }catch (IOException e){

        }
    }

    public void addCustomWindowCloseButton(){
        LevelCloseButton levelCloseButton = new LevelCloseButton("X",jFrame,this);
        this.add(levelCloseButton);
        this.repaint();
        this.revalidate();
    }

    public void resetVariables(){

        timerLabel.isTimeOver = false;
        scoreBoard.score=0;

        timerLabel.setVisible(false);
//        revalidate();
//        repaint();
        scoreBoard.setVisible(false);
//        revalidate();
//        repaint();

//
//        musicPlayer = new MusicPlayer();
//            musicPlayer.playMusic(music);
    }

}
