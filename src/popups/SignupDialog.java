package src.popups;

import src.DatabaseConnection.OracleDatabase;
import src.buttons.BasicBlueButton;
import src.levelObjects.Sound;
import src.setup.FontInfo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class SignupDialog extends AccountDialog {
    JLabel submitFieldLabel;
    AccountDialogTextArea userNameTextArea;
    JLabel userNameFieldLabel;
    BasicBlueButton submitButton;
    AccountDialogLabel accountCreatedExit;
    public SignupDialog(JFrame jFrame, OracleDatabase oracleDatabase){
        super(jFrame, oracleDatabase);
        addUserFieldLabel();
        addEmailFieldLabel("*Email already exists, try again or enter new email");
        addSubmitFieldLabel();
        setVisible(true);
    }

    public SignupDialog(JFrame jFrame){
        super(jFrame);
        addUserFieldLabel();
        addEmailFieldLabel("*Email already exists, try again or enter new email");
        addSubmitFieldLabel();
        setVisible(true);
    }

    protected void addUserFieldLabel() {
        userNameFieldLabel = new JLabel();
        userNameFieldLabel.setPreferredSize(new Dimension(400,70));
        userNameFieldLabel.setLayout(new FlowLayout(FlowLayout.CENTER,10,3));
        userNameFieldLabel.setHorizontalTextPosition(JLabel.LEFT);
        add(userNameFieldLabel);
        userNameFieldLabel.add(createLabel("Username: ", 35));
        addUserNameTextBox();
    }

    protected void addUserNameTextBox() {
        userNameTextArea = new AccountDialogTextArea(400,30);
        userNameTextArea.addFocusEvent("Enter username here");
        userNameFieldLabel.add(userNameTextArea);

    }

    @Override
    void addCancelButton(){
        super.addCancelButton();
        submitFieldLabel.add(cancelButton);
    }

    private void addSubmitButton(){
        submitButton = new BasicBlueButton(120,40,"Submit");
        submitButton.setFont(FontInfo.getResizedFont(30f));
        submitFieldLabel.add(submitButton);
    }
    private void addSubmitFieldLabel(){
        submitFieldLabel = new JLabel();
        submitFieldLabel.setPreferredSize(new Dimension(400,80));
        submitFieldLabel.setLayout(new FlowLayout(FlowLayout.CENTER,10,6));
        submitFieldLabel.setHorizontalTextPosition(JLabel.LEFT);
        add(submitFieldLabel);
        addAccountCreatedExitLabel();
        addSubmitButton();
        addCancelButton();
        addSubmitButtonMouseEvents();
    }
    private void addAccountCreatedExitLabel(){
        accountCreatedExit = new AccountDialogLabel("", 400, 25);
        accountCreatedExit.setForeground(Color.pink);
        accountCreatedExit.setFont(FontInfo.getResizedFont(22f));
        submitFieldLabel.add(accountCreatedExit);
    }

    private void showEmailAlreadyExistsLabel(){
        emailVerificationLabel.setText("*Email already exists, try again or enter new email!");
        emailVerificationLabel.setVisible(true);
        repaint();
    }

    protected void disableUserFields(){
        userNameTextArea.setFocusable(false);
        userNameTextArea.setEnabled(false);
        repaint();
    }

    protected void enableUserFields(){
        userNameTextArea.setEnabled(true);
        userNameTextArea.setFocusable(true);
        repaint();
    }

    private void disableSubmitButton(){
        submitButton.setEnabled(false);
        submitButton.setFocusable(false);
        repaint();
    }

    private void enableSubmitButton(){
        submitButton.setEnabled(true);
        submitButton.setFocusable(true);
        repaint();
    }

    private void addSubmitButtonMouseEvents(){
        submitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
            if(!submitButton.isEnabled()){
                return;
            }
            disableUserFields();
            disableEmailFields();
            disableSubmitButton();
            Thread.sleep(300);
                System.out.println(userNameTextArea.getText());
                System.out.println(emailTextArea.getText());
            if(!isEmailValid(emailTextArea.getText())){
                System.out.println(isEmailValid(emailTextArea.getText()));
                showEmailNotInCurrentFormatLabel();
                enableUserFields();
                enableEmailFields();
                enableSubmitButton();
            }else if(!OracleDatabase.insertUser(userNameTextArea.getText(), emailTextArea.getText())){
                EmailAlreadyRegisteredDialog emailAlreadyRegisteredDialog = new EmailAlreadyRegisteredDialog(returnSelf());
//                        showEmailAlreadyExistsLabel();
                enableUserFields();
                enableEmailFields();
                enableSubmitButton();
            }else{
                doExitCountDown(accountCreatedExit, "Account created successfully");
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    private SignupDialog returnSelf(){
        return this;
    }


}
