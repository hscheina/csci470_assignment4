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
    ArrayList<Ball> arrayListOfBallObjects;
    Dimension dimension;
    Thread animationThread;

    public AnimationPanel() {
        super();
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(300, 500));
        arrayListOfBallObjects = null;
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
            animationThread = new Thread(this::run);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Call the superclass version of the method.
        System.out.println("paint component running");
        Dimension size = getSize();
        //if (size==null) {
        //    setSize(new Dimension(300,500));
        //}

        /*
        • If the Dimension object reference is null, create a set of Ball objects
            and add them to the ArrayList, then get the dimensions of the panel by
            calling getSize().
        • Draw the white background. One easy way to do that is to just a white
            rectangle the same size as the panel.
        • Call the move() and draw() methods for each Ball object in the ArrayList.
            The Dimension object needs to be passed to move(), while the Graphics
            object needs to be passed to draw().
         */
        if (dimension == null) {
            dimension = getSize();
            //Ball ball1 = new Ball(Color.GREEN, 20, (dimension.width * 2 / 3), (dimension.height - 28), -2, -4);
            Ball ball1 = new Ball(Color.GREEN, 25, 0, 0, 0, 0);
            arrayListOfBallObjects.add(ball1);
            Ball ball2 = new Ball(Color.RED, 20, 10, (dimension.height - 28), -2, -4);
            arrayListOfBallObjects.add(ball2);
            Ball ball3 = new Ball(Color.BLUE, 20, (dimension.width * 2 / 3), (dimension.height - 28), -2, -4);
            arrayListOfBallObjects.add(ball3);
        }
        //dimension should be w:300 h:500
        // Dimension d = getSize();
//            dimension = new Dimension(300,500);

        //TODO: get the coordinates of the rectangle
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dimension.width, dimension.height);

        for (Ball b : arrayListOfBallObjects) {
            b.move(dimension);
            b.draw(g);

        }
    }

    @Override
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


        /*
public static void main(String args[]) throws InterruptedException {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("Empty JFrame");
            frame.setSize(new Dimension(1000, 500));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PaintComponentTest ilt = new PaintComponentTest();
            frame.add(ilt);
            frame.setVisible(true);
            ilt.setBackground(Color.BLACK);
        }
    });
}
 */

        System.out.println("run running");

        while (Thread.currentThread() == animationThread) {
            try {
                animationThread.sleep(25);
            } catch (InterruptedException e) {
                return;
            }
            revalidate();
            repaint();
        }
    }

}
