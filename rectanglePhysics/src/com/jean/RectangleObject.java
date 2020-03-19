package com.jean;

import javax.swing.*;
import java.awt.*;

public class RectangleObject {
    Rectangle r;
    private int speedM, jumpM;
    public boolean isJump;
    private ImageIcon ball;
    public RectangleObject(int x, int y, int width, int height, int speedM, int jumpM) {
        r = new Rectangle();
        r.setLocation(x, y);
        r.setSize(width, height);
        ball = new ImageIcon("images/redball.png");
        this.speedM = speedM;
        this.jumpM = jumpM;
        isJump = true;
    }

    public void setSpeedM(int speedM) {
        this.speedM = speedM;
    }

    public void drawRect(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawImage(ball.getImage(), (int) r.getX(), (int) r.getY(), null);
        //g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
    }

    public void moveObjectX(int side) {
        r.x = r.x + side*speedM;
    }

    public void upObjectY() {
        if (isJump == true) {
            r.y = r.y - jumpM;
            isJump = false;
        }
    }

    public void downObjectY() {
        r.y = r.y + jumpM;
        isJump = true;
    }
}
