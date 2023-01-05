package src.buttons;
import src.DatabaseConnection.OracleDatabase;
import src.DatabaseConnection.PlayerInfo;
import src.events.SceneObjectEvents;
import src.levels.ALevelPanel;
import src.popups.LevelFinishDialog;
import src.popups.LevelFinishedNotEnoughScore;
import src.transitionPanels.MapT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ObjectHidingButton extends JButton {

    int positionX;
    int positionY;
    int buttonWidth;
    int buttonHeight;
    public JLabel associatedLabel;
    public ALevelPanel levelPanel;
    int level_number;
    public int myIndex;
    public boolean HintWasUsed = false;

    public ObjectHidingButton(int posx, int posy, int width, int height, JLabel label, ALevelPanel levelPanel, int myIndex){
        this.positionX = posx;
        this.positionY = posy;
        this.buttonWidth = width;
        this.buttonHeight = height;
        this.associatedLabel = label;
        this.levelPanel = levelPanel;
        this.myIndex = myIndex;
        createInvisibleButton();
    }


    public void createInvisibleButton(){

        repaint();

        /* during debugging*/

//        setOpaque(true);
//        setBackground(new Color(255, 0, 0, 100));


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

    public void addSceneEventsListener(ObjectHidingButton button){
        addMouseListener(new SceneObjectEvents(associatedLabel, levelPanel){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isEnabled()) {

                    levelPanel.objClickSound.play();


                    imageLabel.setVisible(false);
                    levelPanel.imagesFound+=1;

                    if((levelPanel.timerLabel.elapsedTime - levelPanel.timeSinceLastFind) < 10){
                        levelPanel.currentCombo++;
                    }else{
                        levelPanel.currentCombo = 0;
                    }

                    levelPanel.timeSinceLastFind = levelPanel.timerLabel.elapsedTime;

                    int gottenScore;
                    if(HintWasUsed){
                        gottenScore = levelPanel.scoreBoard.setScore(50, 0);
                        levelPanel.currentCombo = 0;
                        levelPanel.hintAnimationGif.setVisible(false);
                        HintWasUsed = false;
                    }
                    else{
                        gottenScore = levelPanel.scoreBoard.setScore((int) (levelPanel.timerLabel.elapsedTime/2.0), levelPanel.currentCombo);
                    }
                    levelPanel.scoreBoard.refreshScore();

                    levelPanel.ShowGottenScore.setText("+" + gottenScore);
                    levelPanel.ShowGottenScore.setLocation(button.getLocation());
                    levelPanel.ShowGottenScore.setVisible(true);
                    repaint();
                    levelPanel.timerLabel.AnimateScore(e.getPoint());

                    setEnabled(false);
                    levelPanel.ListOfAllItemNamesAsLabels.get(myIndex).setVisible(false);


                    if(levelPanel.imagesFound == 6 && levelPanel.scoreBoard.score >= levelPanel.PassingScore){
                        levelPanel.timerLabel.isTimeOver = true;
                        levelPanel.congratulationsConfetti.setVisible(true);
                        LevelFinishDialog levelFinishDialog = new LevelFinishDialog(levelPanel.jFrame,level_number,levelPanel);
                        System.out.println("Skipped levelFinishDialogue"); // IT DOESNT SKIP, IT WAITS FOR A RESPONSE
                        if(PlayerInfo.gameProgress < levelPanel.getLevelNumber()){ // first time
                            PlayerInfo.gameProgress = levelPanel.getLevelNumber();
                            levelPanel.loadingAnimationT.LevelOver_ProgressUpdated = true;
                            levelPanel.loadingAnimationT.level_number = levelPanel.getLevelNumber();
                        }
                        switch(levelPanel.getLevelNumber()){
                            case 2 ->{
                                if(PlayerInfo.DormHighScore < levelPanel.scoreBoard.score){
                                    PlayerInfo.DormHighScore = levelPanel.scoreBoard.score;

                                }
                                if(PlayerInfo.DormLeastTime < levelPanel.timerLabel.elapsedTime){
                                    PlayerInfo.DormLeastTime = levelPanel.timerLabel.elapsedTime;
                                }

                                OracleDatabase.updatePlayerStats(2, PlayerInfo.DormHighScore, PlayerInfo.DormLeastTime);

                            }
                            case 3 ->{
                                if(PlayerInfo.ClassroomHighScore < levelPanel.scoreBoard.score){
                                    PlayerInfo.ClassroomHighScore = levelPanel.scoreBoard.score;
                                }
                                if(PlayerInfo.ClassroomLeastTime < levelPanel.timerLabel.elapsedTime){
                                    PlayerInfo.ClassroomLeastTime = levelPanel.timerLabel.elapsedTime;
                                }

                                OracleDatabase.updatePlayerStats(3, PlayerInfo.ClassroomHighScore, PlayerInfo.ClassroomLeastTime);
                            }
                            case 4 ->{
                                if(PlayerInfo.LibraryHighScore < levelPanel.scoreBoard.score){
                                    PlayerInfo.LibraryHighScore = levelPanel.scoreBoard.score;
                                }
                                if(PlayerInfo.LibraryLeastTime < levelPanel.timerLabel.elapsedTime){
                                    PlayerInfo.LibraryLeastTime = levelPanel.timerLabel.elapsedTime;
                                }
                                OracleDatabase.updatePlayerStats(4, PlayerInfo.LibraryHighScore, PlayerInfo.LibraryLeastTime);
                            }
                            case 5 ->{
                                if(PlayerInfo.CDSHighScore < levelPanel.scoreBoard.score){
                                    PlayerInfo.CDSHighScore = levelPanel.scoreBoard.score;
                                }
                                if(PlayerInfo.CDSLeastTime < levelPanel.timerLabel.elapsedTime){
                                    PlayerInfo.CDSLeastTime = levelPanel.timerLabel.elapsedTime;
                                }
                                OracleDatabase.updatePlayerStats(5, PlayerInfo.CDSHighScore, PlayerInfo.CDSLeastTime);
                            }
//                            case 6 ->{
//                                if(PlayerInfo.DormV2HighScore < levelPanel.scoreBoard.score){
//                                    PlayerInfo.DormV2HighScore = levelPanel.scoreBoard.score;
//                                }
//                                if(PlayerInfo.DormV2LeastTime < levelPanel.timerLabel.elapsedTime){
//                                    PlayerInfo.DormV2LeastTime = levelPanel.timerLabel.elapsedTime;
//                                }
//                                OracleDatabase.updatePlayerStats(4, PlayerInfo.DormV2HighScore, PlayerInfo.DormV2LeastTime);
//                            }

                        }

                        levelPanel.timerLabel.isTimeOver = true;
                        levelPanel.imagesFound=0;

                        levelPanel.revalidate();
                        levelPanel.repaint();
                        levelPanel.jFrame.revalidate();
                        levelPanel.jFrame.repaint();

                    } else if (levelPanel.imagesFound == 6) {
                        levelPanel.timerLabel.isTimeOver = true;
                        levelPanel.imagesFound=0;
                        new LevelFinishedNotEnoughScore(levelPanel);
                        levelPanel.revalidate();
                        levelPanel.repaint();
                        levelPanel.jFrame.revalidate();
                        levelPanel.jFrame.repaint();
                    }
                }
                else {
                    levelPanel.PanelClick();
                }

            }
            @Override
            public void mouseEntered(MouseEvent e){
            }
        });
    }


}