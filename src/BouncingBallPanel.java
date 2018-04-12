/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javax.swing.*;
import java.awt.*;

public class BouncingBallPanel extends AnimationPanel {

    JButton start;
    JButton stop;
    AnimationPanel BallAnimationPanel;

    public BouncingBallPanel() {
        BallAnimationPanel = new AnimationPanel();
        BallAnimationPanel.setPreferredSize(new Dimension(300,500));

        start.addActionListener(e -> {
            startAnimation(); //calls method to begin animation
            start.setEnabled(false); //disables the start button
            stop.setEnabled(true); //enables the stop button
        });
        stop.addActionListener(e -> {
            stopAnimation(); //calls method to stop animation
            stop.setEnabled(false); //disables the stop button
            start.setEnabled(true); //enables the start button
        });
    }

    public void startAnimation() {
        BallAnimationPanel.start();
    }

    public void stopAnimation() {
        BallAnimationPanel.stop();
    }
}
