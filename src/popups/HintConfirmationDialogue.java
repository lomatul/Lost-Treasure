package src.popups;

import src.levelObjects.Sound;
import src.levels.ALevelPanel;
import src.setup.DeviceInformation;
import src.setup.FontInfo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class HintConfirmationDialogue extends JDialog {

    JLabel confirmationDialogText;
    ALevelPanel backgroundPanel;
    JButton YesButton;
    int indexOfObjectButton;

    JButton NoButton;
    public HintConfirmationDialogue(JFrame jFrame, ALevelPanel jPanel, int index){
        jPanel.hintConfirmationDialogue = this;
        this.indexOfObjectButton = index;
        this.backgroundPanel = jPanel;
        setModal(true);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#14171C"));
        setLayout(new FlowLayout());
        getRootPane().setBorder(new LineBorder(Color.white,2));
        createConfirmationTextLabel();
        add(confirmationDialogText);
        setSize(DeviceInformation.screenWidth/8,DeviceInformation.screenHeight/3);
        setLocationRelativeTo(jFrame);
        setResizable(false);
        createYesButton();
        addYesButtonMouseListener();
        add(YesButton);
        createNoButton();
        addNoButtonMouseListener();
        add(NoButton);
        setVisible(true);
    }

    private void createConfirmationTextLabel() {
        confirmationDialogText = new JLabel();
        confirmationDialogText.setPreferredSize(new Dimension(DeviceInformation.screenWidth/9,DeviceInformation.screenHeight/5));
        confirmationDialogText.setLayout(new FlowLayout());
        confirmationDialogText.setForeground(Color.white);
        confirmationDialogText.setText(convertToMultiline("See Hint for this Item?\nYou will get less points and loose your combo :("));
        confirmationDialogText.setFont(FontInfo.getResizedFont(31f));
        confirmationDialogText.setHorizontalTextPosition(JLabel.CENTER);

    }

    private void addYesButtonMouseListener() {
        int hintEnlargement = 50;
        YesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                backgroundPanel.buttonList.get(indexOfObjectButton).HintWasUsed = true;
                Rectangle rectangle = backgroundPanel.buttonList.get(indexOfObjectButton).getBounds();
                rectangle.x -= hintEnlargement/2;
                rectangle.y -= hintEnlargement/2;
                rectangle.width += hintEnlargement;
                rectangle.height += hintEnlargement;
                ImageIcon gif = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/Gifs/sparkles.gif")));
                gif.setImage(gif.getImage().getScaledInstance((int)(rectangle.getWidth()), (int)(rectangle.getHeight()), Image.SCALE_DEFAULT));
                backgroundPanel.hintAnimationGif.setIcon(gif);
                backgroundPanel.hintAnimationGif.setBounds(rectangle);
                backgroundPanel.hintAnimationGif.setVisible(true);
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

    private void addNoButtonMouseListener() {
        NoButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sound alert = new Sound();
                alert.setFile("audio/soundeffects/alert.wav");
                alert.play();
                backgroundPanel.hintAnimationGif.setVisible(false);
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

    private void createYesButton() {
        YesButton = new JButton();
        YesButton.setBackground(Color.decode("#14171C"));
        YesButton.setPreferredSize(new Dimension(DeviceInformation.screenWidth/11,DeviceInformation.screenHeight/22));
        YesButton.setFocusPainted(false);
        YesButton.setHorizontalAlignment(JButton.CENTER);
        YesButton.setBorder(new LineBorder(Color.white,2));
        YesButton.setForeground(Color.white);
        YesButton.setFont(FontInfo.getResizedFont(30f));
        YesButton.setOpaque(true);
        YesButton.setText("Yes");
    }

    private void createNoButton() {
        NoButton = new JButton();
        NoButton.setFont(FontInfo.getResizedFont(30f));
        NoButton.setBackground(Color.decode("#14171C"));
        NoButton.setPreferredSize(new Dimension(DeviceInformation.screenWidth/11,DeviceInformation.screenHeight/21));
        NoButton.setFocusPainted(false);
        NoButton.setHorizontalAlignment(JButton.CENTER);
        NoButton.setBorder(new LineBorder(Color.white,2));
        NoButton.setForeground(Color.white);
        NoButton.setOpaque(true);
        NoButton.setText("No");
    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
