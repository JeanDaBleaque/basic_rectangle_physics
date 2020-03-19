package com.jean;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    ImageIcon background;
    Dimension size;
    public Background() {
        super();
        background = new ImageIcon("C:\\background_280.png");
        System.out.println("Running on (" + background.getIconWidth() + "," + background.getIconHeight() + ")");
        size = new Dimension(background.getIconWidth(), background.getIconHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
    }
}
