package com.jean;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Rectangle Physics");
        RectanglePanel panel = new RectanglePanel();
        frame.setVisible(true);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.addKeyListener(panel);
        frame.addWindowListener(panel);
    }
}
