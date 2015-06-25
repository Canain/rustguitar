package com.canain.rustguitar;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Shuyang on 6/19/2015.
 */
public class RustGuitar implements NativeKeyListener {

    private static final int STEP = 10;

    private MouseController mouse;

    private boolean running;

    private int level;

    public RustGuitar() {
        try {
            running = false;
            level = 0;

            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.WARNING);

            GlobalScreen.registerNativeHook();

            mouse = new MouseController();

            GlobalScreen.addNativeKeyListener(this);
        } catch (AWTException | NativeHookException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (mouse == null) {
            return;
        }

        running = true;
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (!running) {
            return;
        }

        switch (e.getKeyCode()) {
            case NativeKeyEvent.VC_I:
                mouse.moveY(-STEP);
                level += STEP;
                break;
            case NativeKeyEvent.VC_K:
                mouse.moveY(STEP);
                level -= STEP;
                break;
            case NativeKeyEvent.VC_J:
                mouse.clickLeft();
                break;
            case NativeKeyEvent.VC_U:
                mouse.moveToY(1080);
                level = 0;
                break;
            case NativeKeyEvent.VC_L:
                System.out.println("\n" + level);
                break;
            default:
                break;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
