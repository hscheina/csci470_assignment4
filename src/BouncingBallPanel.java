/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import java.awt.*;

public class BouncingBallPanel extends AnimationPanel {

    public AnimationPanel BallAnimationPanel;


    public BouncingBallPanel() {
        BallAnimationPanel = new AnimationPanel();
        BallAnimationPanel.setPreferredSize(new Dimension(300, 500));
        setSize(new Dimension(300, 500));
        BallAnimationPanel.setLayout(new BorderLayout());
        this.add(BallAnimationPanel, BorderLayout.EAST);
        setVisible(false);

    }

    public void startAnimation() {
        BallAnimationPanel.start();
    }

    public void stopAnimation() {
        BallAnimationPanel.stop();
    }
}