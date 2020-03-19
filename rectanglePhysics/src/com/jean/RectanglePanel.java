package com.jean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectanglePanel extends JPanel implements MouseListener, KeyListener, ActionListener, WindowListener {

    RectangleObject object;
    Structures[] structures;
    Timer jumpTimer;
    private int x, y, width, height, speedM, jumpM, structureCount;
    ImageIcon background, structure;
    Dimension size;

    public RectanglePanel() {
        super();
        structure = new ImageIcon("images/brick.png");
        background = new ImageIcon("images/background_280.png");
        System.out.println("Running on (" + background.getIconWidth() + "x" + background.getIconHeight() + ").");
        size = new Dimension(background.getIconWidth(), background.getIconHeight());
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        width = 64;
        height = 64;
        speedM = 4;
        jumpM = 64;
        x = 0;
        y = 290 - (height);
        structureCount = 6;
        structures = new Structures[structureCount];
        object = new RectangleObject(x, y, width, height, speedM, jumpM);
        addMouseListener(this);
        jumpTimer = new Timer(1500, this::actionPerformed);
        jumpTimer.setInitialDelay(1500);
        structures[0] = new Structures(320, 290 - height, width, height, structure);
        structures[1] = new Structures(320 + width, 290 - height, width, height, structure);
        structures[2] = new Structures(320 + 2 * width, 290 - height, width, height, structure);
        structures[3] = new Structures(320 + width, 290 - 2 * height, width, height, structure);
        structures[4] = new Structures(320 + 2 * width, 290 - 2 * height, width, height, structure);
        structures[5] = new Structures(320 + 2 * width, 290 - 3 * height, width, height, structure);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
        for (int i = 0; i < structureCount; i++) {
            structures[i].drawStructure(g);
        }
        object.drawRect(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int control = 0;
        if (e.getKeyCode() == e.VK_LEFT) {
            for (int i = 0; i < structureCount; i++) {
                if ((int) object.r.getX() - speedM >= structures[i].r.getX() && (int) object.r.getX() - speedM < (int) (structures[i].r.getX() + structures[i].r.getWidth()) && object.r.getY() + object.r.getHeight() > structures[i].r.getY()) {
                    control = 1;
                }
            }
            if (control == 0) {
                object.moveObjectX(-1);
                if (object.r.getX() < -1 * (int) object.r.getWidth()) {
                    object.r.setLocation(640 + (int) object.r.getWidth() + (int) object.r.getWidth(), (int) object.r.getY());
                }
                repaint();
            }
        } else if (e.getKeyCode() == e.VK_RIGHT) {
            for (int i = 0; i < structureCount; i++) {
                if ((int) object.r.getX() + speedM + (int) object.r.getWidth() > (int) structures[i].r.getX() && (int) object.r.getX() + speedM + (int) object.r.getWidth() <= (int) (structures[i].r.getX() + structures[i].r.getWidth()) && object.r.getY() + object.r.getHeight() > structures[i].r.getY()) {
                    control = 1;
                }
            }
            if (control == 0) {
                object.moveObjectX(1);
                if (object.r.getX() > 640 + (int) object.r.getWidth()) {
                    object.r.setLocation(-1 * (int) object.r.getWidth(), (int) object.r.getY());
                }
                repaint();
            }

        } else if (e.getKeyCode() == e.VK_UP) {
            if (object.isJump == true) {
                object.upObjectY();
                repaint();
                for (int i=0;i<structureCount;i++) {
                    if (object.r.getY()+object.r.getHeight()+jumpM > structures[i].r.getY() && object.r.getY()+object.r.getHeight()+jumpM <= structures[i].r.getY()+structures[i].r.getHeight()) {
                        control = 1;
                    }
                }
                if (control == 0) {
                    jumpTimer.restart();
                }
                else if (control == 1) {
                    object.isJump = true;
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        object.downObjectY();
        repaint();
        jumpTimer.stop();
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
