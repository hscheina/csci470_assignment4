/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javax.swing.*;
import java.awt.*;

public class BouncingBallPanel extends JPanel {

    Dimension btnSize = new Dimension(100, 30);
    JButton startBtn;
    JButton stopBtn;
    AnimationPanel BallAnimationPanel;

    public BouncingBallPanel() {
        BallAnimationPanel = new AnimationPanel();
        BallAnimationPanel.setPreferredSize(new Dimension(300,500));

        startBtn = new JButton("Start");
        startBtn.setPreferredSize(btnSize);
        stopBtn = new JButton("Stop");
        stopBtn.setPreferredSize(btnSize);

        startBtn.addActionListener(e -> {
            startAnimation(); //calls method to begin animation
            startBtn.setEnabled(false); //disables the start button
            stopBtn.setEnabled(true); //enables the stop button
        });
        stopBtn.addActionListener(e -> {
            stopAnimation(); //calls method to stop animation
            stopBtn.setEnabled(false); //disables the stop button
            startBtn.setEnabled(true); //enables the start button
        });
    }

    public void startAnimation() {
        BallAnimationPanel.start();
    }

    public void stopAnimation() {
        BallAnimationPanel.stop();
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getStopBtn() {
        return stopBtn;
    }
}
