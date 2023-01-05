package src.levelObjects;

import src.setup.FontInfo;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JLabel{
    public Integer score;
    int baseScore;
    int comboBonus;
    JFrame jFrame;
    JPanel backGroundPanel;

    public ScoreBoard(JFrame jFrame, JPanel backGroundPanel) {
        this.jFrame = jFrame;
        this.backGroundPanel = backGroundPanel;
        SetupScoreBoard();
        score = 0;
        baseScore = 100;
        comboBonus = 10;
        refreshScore();
    }
    public void SetupScoreBoard(){
        this.setBounds(130,5, 150, 45);
        this.setBackground(Color.decode("#14171C"));
        this.setForeground(Color.decode("#FFFF9F"));
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(0,20,0,20)));
        this.setOpaque(true);
        this.setFont(FontInfo.getResizedFont(35f));

        backGroundPanel.repaint();
        backGroundPanel.revalidate();
        backGroundPanel.add(this);
    }
    public int setScore(int deduction, int combo){
        int toBeAdded = baseScore - deduction + combo*comboBonus;
        score += toBeAdded;
        return toBeAdded;
    }

    public void refreshScore(){
        if(score < 1000)
            this.setText(" 0" + score);
        else
            this.setText(score.toString());

        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.repaint();
        backGroundPanel.repaint();
    }


}
