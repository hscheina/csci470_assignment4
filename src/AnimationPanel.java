/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics;

public class AnimationPanel extends JPanel implements Runnable {
    private ArrayList<Ball> arrayListOfBallObjects;
    Dimension dimension;
    Thread animationThread;

    public AnimationPanel() {
        super();
        arrayListOfBallObjects = new ArrayList<>();
        dimension = null;
        animationThread = null;
    }

    public void start() {
        /*
        – If the Thread reference is null, create a new Thread object from this
        class and call the Thread’s start() method to make it runnable by the
        thread scheduler.
         */
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }



    }

    public void stop() {
        /*
        Call interrupt() for the Thread and then set its reference to null.
        This will cause the loop in the run() method to exit. Once the loop is
        finished, the method is finished as well, so the thread will terminate.
         */
        animationThread.interrupt();
        animationThread = null;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dimension == null) {
            dimension = new Dimension(300,500);
            Ball ball1 = new Ball(Color.GREEN, 20, 150, 150, 1, 10);
            Ball ball2 = new Ball(Color.RED, 20, 10, (dimension.height - 45), 2, 9);
            Ball ball3 = new Ball(Color.BLUE, 20, (dimension.width * 2 / 3), (dimension.height - 45), 2, 4);
            arrayListOfBallObjects.add(ball1);
            arrayListOfBallObjects.add(ball2);
            arrayListOfBallObjects.add(ball3);
        }

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dimension.width, dimension.height);

        for (Ball b : arrayListOfBallObjects) {
            b.move(dimension);
            b.draw(g);

        }
    }



    public void run() {

        while (Thread.currentThread() == animationThread) {
            try {
                animationThread.sleep(25);

            } catch (InterruptedException e) {
                return;
            }
            repaint();

        }
    }

}
