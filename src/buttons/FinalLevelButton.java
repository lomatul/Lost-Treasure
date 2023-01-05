package src.buttons;

import src.DatabaseConnection.OracleDatabase;
import src.DatabaseConnection.PlayerInfo;
import src.events.SceneObjectEvents;
import src.levels.ALevelPanel;
import src.levels.DormVersion2;
import src.popups.FinalLevelCompletedPopUp;
import src.popups.LevelFinishDialog;
import src.popups.LevelFinishedNotEnoughScore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class FinalLevelButton extends JButton{

    int positionX;
    int positionY;
    int buttonWidth;
    int buttonHeight;
    public JLabel associatedLabel;
    public DormVersion2 levelPanel;
    public int myIndex;
    public boolean HintWasUsed = false;

    public FinalLevelButton(int posx, int posy, int width, int height, JLabel associatedLabel, DormVersion2 levelPanel, int myIndex) {
        this.positionX = posx;
        this.positionY = posy;
        this.buttonWidth = width;
        this.buttonHeight = height;
        this.associatedLabel = associatedLabel;
        this.levelPanel = levelPanel;
        this.myIndex = myIndex;
        createInvisibleButton();
    }

    public void createInvisibleButton(){

        repaint();

        /* during debugging*/

//        setOpaque(true);
        setBackground(new Color(255, 0, 0, 100));


        /* stuff that works*/

        setOpaque(false);
        setContentAreaFilled(false);

        repaint();
        setFocusPainted(false);
        setBorderPainted(false);
        setEnabled(false);

        setBounds(positionX,positionY,buttonWidth,buttonHeight);
        addSceneEventsListener(this);

    }

    public void addSceneEventsListener(FinalLevelButton button){
        addMouseListener(new SceneObjectEvents(associatedLabel, levelPanel){
            @Override
            public void mouseClicked(MouseEvent e) {

//                if(!isEnabled())
//                    return;

//                if(levelPanel.taps == 0){
//                    levelPanel.imageList.get(0).setVisible(false);
//                    levelPanel.imageList.get(1).setVisible(true);
//                }
//                else if(levelPanel.taps == 1) {
//                    levelPanel.imageList.get(1).setVisible(false);
//                }
//
//                levelPanel.taps++;








                if(isEnabled()) {
                    System.out.println("idk man, me a button got pushed, was enabled");

                    levelPanel.objClickSound.play();

                    levelPanel.taps++;

                    setEnabled(false);
//                    associatedLabel.setVisible(false);
                    // here images found works more like taps on the screen

                    switch (myIndex){
                        case 0 -> { // meow
                            System.out.println("meow");
                            levelPanel.imageList.get(myIndex).setVisible(false);
                            levelPanel.imageList.get(2).setVisible(false);
                            levelPanel.buttonList.get(3).setEnabled(true);

                            levelPanel.TextBox.setText(levelPanel.textList.get(3));
                        }
                        case 1 -> { //dorm
                            System.out.println("dorm");
                            levelPanel.imageList.get(myIndex).setVisible(false);
                            levelPanel.buttonList.get(myIndex+1).setEnabled(true);

                            levelPanel.TextBox.setText(levelPanel.textList.get(myIndex+1));
                        }
                        case 2 -> { //almari
                            System.out.println("almari");
                            levelPanel.imageList.get(0).setVisible(true);
                            levelPanel.buttonList.get(0).setEnabled(true);

                            levelPanel.catSound.play();
                            levelPanel.TextBox.setText(levelPanel.textList.get(0));
                        }
                        case 3 -> { //bed blanket
                            System.out.println("bed blanket");
                            levelPanel.imageList.get(myIndex).setVisible(false);
                            levelPanel.buttonList.get(myIndex+1).setEnabled(true);

                            levelPanel.TextBox.setText(levelPanel.textList.get(myIndex+1));
                        }
                        case 4 -> { //bed bag
                            System.out.println("bed bag");
                            levelPanel.imageList.get(myIndex).setVisible(false);
                            levelPanel.buttonList.get(myIndex+1).setEnabled(true);

                            levelPanel.TextBox.setText(levelPanel.textList.get(myIndex+1));
                        }
                        case 5 -> { //cat
                            System.out.println("cat");
                            levelPanel.imageList.get(myIndex).setVisible(false);
                            levelPanel.buttonList.get(myIndex+1).setEnabled(true);

                            levelPanel.TextBox.setText(levelPanel.textList.get(myIndex+1));
                        }
                        case 6 ->{ // portait
                            System.out.println("portrait");
                        }

                    }
//                    if(levelPanel.buttonList.size()-1 >= myIndex+1){
//                        System.out.println("making future visible");
//                        levelPanel.buttonList.get(myIndex + 1).setEnabled(true);
//                        levelPanel.imageList.get(myIndex+1).setVisible(true);
//
//                    }

                    if(levelPanel.taps == levelPanel.imageList.size()){
                        System.out.println("level ended");
                        levelPanel.congratulationsConfetti.setVisible(true);

                        FinalLevelCompletedPopUp finalLevelCompletedPopUp = new FinalLevelCompletedPopUp(levelPanel.jFrame, levelPanel.getLevelNumber(), levelPanel);

                        System.out.println("Skipped levelFinishDialogue"); // IT DOESNT SKIP, IT WAITS FOR A RESPONSE FROM THE JDIALOGUE

                        if(PlayerInfo.gameProgress < levelPanel.getLevelNumber()){ // first time
                            PlayerInfo.gameProgress = levelPanel.getLevelNumber();
                        }

                        levelPanel.taps=0;
                        levelPanel.EndLevel();
                        if(levelPanel.backgroundMusic != null) {
                            levelPanel.backgroundMusic.stop();
                        }

                        levelPanel.revalidate();
                        levelPanel.repaint();
                        levelPanel.jFrame.revalidate();
                        levelPanel.jFrame.repaint();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                repaint();
                revalidate();
            }
        });
    }
}
