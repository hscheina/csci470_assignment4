/***************************************************
 * Haley Scheina & Alonso Arteaga
 * CSCI 470
 * Assignment 4
 **************************************************/

import java.awt.*;

public abstract class Main {

    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            DrawGui gui = new DrawGui();
            gui.createAndShowGUI();
        });

    }

}
