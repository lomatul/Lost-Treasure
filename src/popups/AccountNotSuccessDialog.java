package src.popups;

import src.buttons.BasicBlueButton;
import src.levelObjects.Sound;
import src.setup.FontInfo;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class AccountNotSuccessDialog extends JDialog {

    AccountDialog parentAccountDialog;
    BasicBlueButton yesButton;
    BasicBlueButton noButton;
    AccountDialogLabel unsuccessfulReasonLabel;
    JLabel buttonFieldLabel;
    public AccountNotSuccessDialog(AccountDialog accountDialog){
        this.parentAccountDialog = accountDialog;
        addDialogStyles();
    }

    protected void addButtonFieldLabel(){
        buttonFieldLabel = new JLabel();
        buttonFieldLabel.setPreferredSize(new Dimension(400, 50));
        buttonFieldLabel.setLayout(new FlowLayout());
        buttonFieldLabel.setHorizontalAlignment(JLabel.CENTER);
        add(buttonFieldLabel);
    }

    protected void addUnsuccessfulReasonLabel(String text){
        unsuccessfulReasonLabel = new AccountDialogLabel(text, 400, 50);
        unsuccessfulReasonLabel.setFont(FontInfo.getResizedFont(28f));
        add(unsuccessfulReasonLabel);
    }

    protected void addYesButton(String text){
        yesButton = new BasicBlueButton(180, 40, text);
        yesButton.setFont(FontInfo.getResizedFont(30f));
        buttonFieldLabel.add(yesButton);
        addYesButtonMouseEvents();
    }

    protected void addYesButtonMouseEvents(){
        yesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound countdown= new Sound();
                countdown.setFile("audio/soundeffects/countdown.wav");
                countdown.play();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
    }
    protected void addNoButton(){
        noButton = new BasicBlueButton(180, 40, "Try Again!");
        noButton.setFont(FontInfo.getResizedFont(30f));
        buttonFieldLabel.add(noButton);
        addNoButtonMouseEvents();
    }
    protected void addDialogStyles() {
        setModal(true);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout(FlowLayout.CENTER, 12, 12));
        getRootPane().setBorder(new LineBorder(Color.white,2));
        setSize(500,135);
        setLocationRelativeTo(parentAccountDialog);
        setResizable(false);
    }

    private void addNoButtonMouseEvents(){
        noButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
    }

}
