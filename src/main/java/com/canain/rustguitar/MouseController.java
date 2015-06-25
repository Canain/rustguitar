package com.canain.rustguitar;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Shuyang on 6/19/2015.
 */
public class MouseController {

    private static int MOUSE_LEFT = InputEvent.BUTTON1_DOWN_MASK;
    private static int MOUSE_RIGHT = InputEvent.BUTTON3_DOWN_MASK;

    private Robot robot;

    public MouseController() throws AWTException {
        robot = new Robot();
    }

    public Point getPos() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public int getPosX() {
        return getPos().x;
    }

    public int getPosY() {
        return getPos().y;
    }

    public void moveTo(int x, int y) {
        robot.mouseMove(x, y);
    }

    public void moveToX(int x) {
        robot.mouseMove(x, getPosY());
    }

    public void moveToY(int y) {
        robot.mouseMove(getPosX(), y);
    }

    public void move(int x, int y) {
        Point pos = getPos();
        moveTo(pos.x + x, pos.y + y);
    }

    public void moveX(int x) {
        move(x, 0);
    }

    public void moveY(int y) {
        move(0, y);
    }

    public void clickLeft() {
        robot.mousePress(MOUSE_LEFT);
        robot.mouseRelease(MOUSE_LEFT);
    }

    public void clickRight() {
        robot.mousePress(MOUSE_RIGHT);
        robot.mouseRelease(MOUSE_RIGHT);
    }
}
