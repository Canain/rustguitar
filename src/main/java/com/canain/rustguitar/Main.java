package com.canain.rustguitar;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by Shuyang on 6/19/2015.
 */
public class Main {

    public static void main(String[] args) {
        RustGuitar guitar = new RustGuitar();
        Scanner scan = new Scanner(System.in);

        String next;
        while (scan.hasNextLine()) {
            next = scan.nextLine();
            if (next.equalsIgnoreCase("stop")) {
                break;
            }
            if (guitar.isRunning()) {
                guitar.stop();
                System.out.println("Stopped");
            } else {
                guitar.start();
                System.out.println("Started");
            }
        }
    }
}
