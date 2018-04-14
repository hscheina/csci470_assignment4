/***************************************************
 * Alonso Arteaga & Haley Scheina
 * CSCI 470
 * Assignment 4
 **************************************************/

import javax.swing.*;
import java.awt.*;

public abstract class Main {

    public static void main(String[] args){
            EventQueue.invokeLater(() -> {
                DrawGui frame = new DrawGui();
                frame.createAndShowGUI();
            });
        }

    }


