/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BouncingBallPanel extends JPanel {

    Dimension btnSize = new Dimension(100, 30);
    JButton startBtn;
    JButton stopBtn;
    AnimationPanel BallAnimationPanel;



    public BouncingBallPanel() {
        BallAnimationPanel = new AnimationPanel();
        //BallAnimationPanel.setPreferredSize(new Dimension(300,500));
        setPreferredSize(new Dimension(300,500));
//        setBackground(java.awt.Color.BLUE);

        startBtn = new JButton("Start");
        startBtn.setPreferredSize(btnSize);
        stopBtn = new JButton("Stop");
        stopBtn.setPreferredSize(btnSize);

        setVisible(true);
        startBtn.addActionListener(e -> {
//            startAnimation(); //calls method to begin animation
//            startBtn.setEnabled(false); //disables the start button
//            stopBtn.setEnabled(true); //enables the stop button
            actionPerformed(e);});

        // TODO: 4/13/18 clicking stop button at start of program, throws a null pointer exception. make it unclickable
        stopBtn.addActionListener(e -> {
//            stopAnimation(); //calls method to stop animation
//            stopBtn.setEnabled(false); //disables the stop button
//            startBtn.setEnabled(true); //enables the start button
            actionPerformed(e);
        });
    }

    public void startAnimation() {
        BallAnimationPanel.start();
    }

    public void actionPerformed(ActionEvent cmd){
        if(cmd.equals("Start")){
            startAnimation();
            startBtn.setEnabled(false);
            stopBtn.setEnabled(true);
        } else if (cmd.equals("Stop")){
            stopAnimation();
            startBtn.setEnabled(true);
            stopBtn.setEnabled(false);
        }
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
