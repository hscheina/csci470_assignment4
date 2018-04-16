/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javax.swing.*;
import java.awt.*;
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

public abstract class Main {

    public static void main(String[] args){
            EventQueue.invokeLater(() -> {
                DrawGui frame = new DrawGui();
                frame.createAndShowGUI();
            });
        }

    }


