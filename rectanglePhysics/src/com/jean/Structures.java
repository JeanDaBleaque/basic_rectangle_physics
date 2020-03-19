package com.jean;

import javax.swing.*;
import java.awt.*;

public class Structures {
    Rectangle r;
    private ImageIcon structure;
    public Structures(int x, int y, int width, int height, ImageIcon img) {
        structure = new ImageIcon();
        structure.setImage(img.getImage());
        r = new Rectangle();
        r.setLocation(x, y);
        r.setSize(width, height);
    }
    public void drawStructure(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawImage(structure.getImage(), (int) r.getX(), (int) r.getY(), null);
    }
}
