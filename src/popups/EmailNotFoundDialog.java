package src.popups;

import src.levelObjects.Sound;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmailNotFoundDialog extends AccountNotSuccessDialog{

    public EmailNotFoundDialog(AccountDialog accountDialog) {
        super(accountDialog);
        addUnsuccessfulReasonLabel("Email not Found!");
        addButtonFieldLabel();
        addYesButton("Create Account");
        addNoButton();
        setVisible(true);
    }

    @Override
    protected void addYesButtonMouseEvents(){
        yesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Sound clicksound= new Sound();
                clicksound.setFile("audio/soundeffects/click.wav");
                clicksound.play();
                parentAccountDialog.dispose();
                SignupDialog signupDialog = new SignupDialog(parentAccountDialog.jFrame, parentAccountDialog.database);
                parentAccountDialog.jFrame.repaint();
                parentAccountDialog.jFrame.revalidate();
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

