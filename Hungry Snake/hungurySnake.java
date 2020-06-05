import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class hungrySnake {

    public static void main(String[] args) {
        HSMap map = new HSMap("Kobe's hungry snake");
        map.setMatrix();
        map.init();
        MyThread playGame = new MyThread(map);
        playGame.start();
    }
}

class DrawPanel extends JPanel {
    int x, y;
    HSMap map;
    int blockSize;

    DrawPanel(int blockSize, HSMap map) {
        this.x = map.mm[0].length;
        this.y = map.mm.length;
        this.blockSize = blockSize;
        this.map = map;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                g.setColor(Color.BLACK);
                g.drawRect(blockSize * i, blockSize * j, blockSize, blockSize);
                if (this.map.mm[j][i] == 1) { // Box
                    g.setColor(Color.ORANGE);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5, blockSize - 10, blockSize - 10);
                } else if (this.map.mm[j][i] == 2) { // Hole
                    g.setColor(Color.BLUE);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5, blockSize - 10, blockSize - 10);
                } else if (this.map.mm[j][i] == 3) { // Player
                    g.setColor(Color.RED);
                    g.fillOval(blockSize * i + 10, blockSize * j + 10, blockSize - 20, blockSize - 20);
                }
            }
        }
    }
}

class MyThread extends Thread {
    HSMap map;

    MyThread(HSMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            map.moveOn();

            if (map.result != 0)
                break;
            try {
                sleep(250); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // display();
    }

    // void display() {
    // int score = this.map.length - 3;
    // int temp;
    // int[] list = new int[10];
    // File myFile = new File("./ranking.txt");

    // try {
    // Scanner readRank = new Scanner(myFile);
    // for (int i = 0; i < 10; i++) {
    // if (readRank.hasNextLine()) {
    // temp = readRank.nextInt();
    // if (temp < score) {
    // list[i] = score;
    // score = temp;
    // } else {
    // list[i] = temp;
    // }
    // } else {
    // break;
    // }
    // }
    // } catch (Exception e) {
    // System.out.println("Error: " + e);
    // }

    // try {

    // } catch (Exception e) {
    // System.out.println("Error: " + e);
    // }
    // }
}