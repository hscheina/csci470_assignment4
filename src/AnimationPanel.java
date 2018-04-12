/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimationPanel extends JPanel {
    ArrayList<Ball> arrayListOfBallObjects;
    Dimension dimension;
    Thread thread;

    public void start() {
        /*
        – If the Thread reference is null, create a new Thread object from this
        class and call the Thread’s start() method to make it runnable by the
        thread scheduler.
         */
        if (thread == null) {
            thread = new Thread();
            thread.start();
        }
    }

    public void stop() {
        /*
        Call interrupt() for the Thread and then set its reference to null.
        This will cause the loop in the run() method to exit. Once the loop is
        finished, the method is finished as well, so the thread will terminate.
         */
        thread.interrupt();
        thread = null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        /*
        Call the superclass version of the method.
        • If the Dimension object reference is null, create a set of Ball objects
            and add them to the ArrayList, then get the dimensions of the panel by
            calling getSize().
        • Draw the white background. One easy way to do that is to just a white
            rectangle the same size as the panel.
        • Call the move() and draw() methods for each Ball object in the ArrayList.
            The Dimension object needs to be passed to move(), while the Graphics
            object needs to be passed to draw().
         */
        super.paintComponent(g);
        if (dimension == null) {
            Ball ball1 = new Ball();
                arrayListOfBallObjects.add(ball1);
            Ball ball2 = new Ball();
                arrayListOfBallObjects.add(ball2);
            Ball ball3 = new Ball();
                arrayListOfBallObjects.add(ball3);

            //TODO: access size of BouncingBallPanel and assign it to dimension
            //dimension = BouncingBallPanel.getPreferredSize();

            for (Ball b : arrayListOfBallObjects) {
                b.move(dimension);
                b.draw(g);
            }
        }
    }

    public void run() {
        /*
        This is effectively the “main” method that will run in the separate
        background thread. It will have a loop that continues while the
        current thread is equal to the Thread reference data member, e.g.:

                while (Thread.currentThread == animationThread)

        The loop body should put the thread to sleep for a short amount of
        time (25 milliseconds is about right), and then call repaint()
        (which will eventually result in paintComponent() being executed).
        If the thread is interrupted, just return from the method.
         */

    }
}
