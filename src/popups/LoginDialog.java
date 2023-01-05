package src.popups;

import src.DatabaseConnection.OracleDatabase;
import src.buttons.BasicBlueButton;
import src.levelObjects.Sound;
import src.setup.FontInfo;
import src.transitionPanels.StartMenuScreenT;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class LoginDialog extends AccountDialog {

    JLabel loginFieldLabel;
    BasicBlueButton loginButton;
    AccountDialogLabel loginSuccessFullExitLabel;
    public boolean isLoggedIn=false;
    StartMenuScreenT startMenuScreenT;
    public LoginDialog(JFrame jFrame, OracleDatabase oracleDatabase) {
        super(jFrame, oracleDatabase);
        setSize(500, 220);
        addEmailFieldLabel("*Enter email in correct format!");
        addLoginFieldLabel();
        setVisible(true);
    }
    public LoginDialog(JFrame jFrame){
        super(jFrame);
        setSize(500, 220);
        addEmailFieldLabel("*Enter email in correct format!");
        addLoginFieldLabel();
        setVisible(true);
    }

    public void addStartMenuSceneT(StartMenuScreenT startMenuScreenT){
        this.startMenuScreenT = startMenuScreenT;
    }


    @Override
    void doExitCountDown(AccountDialogLabel exitLabel, String text){
        Timer timer = new Timer(0, new ActionListener() {
            int seconds = 2;
            @Override
            public void actionPerformed(ActionEvent e) {
                exitLabel.updateText(seconds, text);
                if(seconds==-1){
                    isLoggedIn = true;
                    dispose();
                    return;
                }
                seconds--;

            }
        });

        timer.setDelay(1000);
        timer.start();
    }
    public void changeButtons(StartMenuScreenT startMenuScreenT){
        startMenuScreenT.remove(startMenuScreenT.loginButton);
        startMenuScreenT.repaint();
        startMenuScreenT.revalidate();
        startMenuScreenT.remove(startMenuScreenT.signupButton);
        startMenuScreenT.repaint();

        startMenuScreenT.revalidate();
    }
    private void addLoginSuccessFullExitLabel(){
        loginSuccessFullExitLabel = new AccountDialogLabel("", 400, 25);
        loginSuccessFullExitLabel.setForeground(Color.pink);
        loginSuccessFullExitLabel.setFont(FontInfo.getResizedFont(25f));
        loginFieldLabel.add(loginSuccessFullExitLabel);
    }

    private void addLoginFieldLabel(){
        loginFieldLabel = new JLabel();
        loginFieldLabel.setPreferredSize(new Dimension(400,80));
        loginFieldLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 6));
        loginFieldLabel.setHorizontalTextPosition(JLabel.LEFT);
        add(loginFieldLabel);
        addLoginSuccessFullExitLabel();
        addLoginButton();
        addCancelButton();
    }

    @Override
    void addCancelButton(){
        super.addCancelButton();
        loginFieldLabel.add(cancelButton);
    }
    private void addLoginButton(){
        loginButton = new BasicBlueButton(120, 40, "Login");
        loginButton.setFont(FontInfo.getResizedFont(30f));
        loginFieldLabel.add(loginButton);
        addLoginButtonMouseEvents();
    }

    private void disableLoginButton(){
        loginButton.setFocusable(false);
        loginButton.setEnabled(false);
        repaint();
    }
    private void enableLoginButton(){
        loginButton.setFocusable(true);
        loginButton.setEnabled(true);
        repaint();
    }
    

    private void addLoginButtonMouseEvents(){
        loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound clicksound= new Sound();
                clicksound.setFile("audio/soundeffects/click.wav");
                clicksound.play();

                Sound countdown= new Sound();
                countdown.setFile("audio/soundeffects/countdown.wav");
                countdown.play();

                doButtonActions();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                doButtonActions();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void doButtonActions() {
        try {
            if(!loginButton.isEnabled()){
                return;
            }
            disableEmailFields();
            disableLoginButton();
            Thread.sleep(200);

            System.out.println(emailTextArea.getText());
            if(!isEmailValid(emailTextArea.getText())){
                System.out.println(isEmailValid(emailTextArea.getText()));
                showEmailNotInCurrentFormatLabel();
                enableEmailFields();
                enableLoginButton();
            }else if(OracleDatabase.retrieveUserInfo(emailTextArea.getText())){
                doExitCountDown(loginSuccessFullExitLabel, "Login successful");
            }else{
                EmailNotFoundDialog emailNotFoundDialog = new EmailNotFoundDialog(returnSelf());
                enableEmailFields();
                enableLoginButton();
            }
        }catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    private LoginDialog returnSelf(){
        return this;
    }

}
