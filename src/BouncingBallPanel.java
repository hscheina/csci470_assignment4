/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallPanel extends JPanel {

    Dimension btnSize = new Dimension(100, 30);
    JButton startBtn;
    JButton stopBtn;

    AnimationPanel BallAnimationPanel;



    public BouncingBallPanel() {
        BallAnimationPanel = new AnimationPanel();
        BallAnimationPanel.setBackground(java.awt.Color.BLUE);
        setPreferredSize(new Dimension(300,500));
        setLayout(new GridLayout());
//        setBounds(new Rectangle(100,100));
        startBtn = new JButton("Start");
        startBtn.setPreferredSize(btnSize);
        stopBtn = new JButton("Stop");
        stopBtn.setPreferredSize(btnSize);
        stopBtn.setEnabled(false);

        //setVisible(true);
//        startBtn.addActionListener(e -> {
////            startAnimation(); //calls method to begin animation
////            startBtn.setEnabled(false); //disables the start button
////            stopBtn.setEnabled(true); //enables the stop button
//            actionPerformed(e);});
        startBtn.addActionListener(e -> {
            startAnimation(); //calls method to begin animation
            startBtn.setEnabled(false); //disables the start button
            stopBtn.setEnabled(true); //enables the stop button
            });

        stopBtn.addActionListener(e -> {
            stopAnimation(); //calls method to begin animation
            startBtn.setEnabled(true); //disables the start button
            stopBtn.setEnabled(false); //enables the stop button
            });
 //           actionPerformed(e);});

//        startBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startAnimation();
//                BallAnimationPanel.start();
//                startBtn.setEnabled(false);
//                stopBtn.setEnabled(true);
//            }
//        });

        // TODO: 4/13/18 clicking stop button at start of program, throws a null pointer exception. make it unclickable
//        stopBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                stopAnimation(); //calls method to stop animation
//                stopBtn.setEnabled(false); //disables the stop button
//                startBtn.setEnabled(true); //enables the start button
//            }
//        });

    }

    public void startAnimation() {
        BallAnimationPanel.start();
    }

//    public void actionPerformed(ActionEvent cmd){
//        if(cmd.equals("Start")){
//            startAnimation();
//            BallAnimationPanel.start();
//            startBtn.setEnabled(false);
//            stopBtn.setEnabled(true);
//        } else if (cmd.equals("Stop")){
//            stopAnimation();
//            BallAnimationPanel.stop();
//            startBtn.setEnabled(true);
//            stopBtn.setEnabled(false);
//        }
//    }

    public void stopAnimation() {
        BallAnimationPanel.stop();
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getStopBtn() {
        return stopBtn;
    }

    public AnimationPanel getAnimationPanel() { return BallAnimationPanel; }
}
