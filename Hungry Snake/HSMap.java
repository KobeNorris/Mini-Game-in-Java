import java.awt.*;
import java.util.*;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class HSMap extends JFrame {
    int blockSize = 40;
    int x, y, xm, ym;
    JLabel showLength;
    DrawPanel mainMap;
    int result = 0;
    int[] sx, sy;
    int[][] mm;
    char direction = 'd';
    int length;

    HSMap(String title) {
        super(title);
    }

    void setMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input x and y: ");
        this.x = input.nextInt();
        this.y = input.nextInt();

        if (x < 5 || y < 5) {
            System.out.println("The map is too small");
            System.exit(1);
        } else {
            this.sx = new int[this.x * this.y];
            for (int t = 0; t < this.x * this.y; t++)
                this.sx[t] = -1;
            sx[0] = 4;
            sx[1] = 3;
            sx[2] = 2;
            this.sy = new int[this.x * this.y];
            for (int t = 0; t < this.x * this.y; t++)
                this.sy[t] = -1;
            sy[0] = 2;
            sy[1] = 2;
            sy[2] = 2;

            xm = 2;
            ym = 2;
        }

        setFood();
        refreshGraph();
    }

    void setFood() {
        int flag = 0;

        xm = (int) Math.floor(Math.random() * this.x);
        ym = (int) Math.floor(Math.random() * this.y);
        while (true) {
            for (int i = 0; i < this.x * this.y; i++)
                if (xm == sx[i] && ym == sy[i])
                    flag++;

            if (flag == 0)
                break;
            flag = 0;
            xm = (int) Math.floor(Math.random() * x);
            ym = (int) Math.floor(Math.random() * y);
        }
    }

    void refreshGraph() {
        this.mm = new int[y][x];
        for (int i = 0; i < this.x * this.y; i++) {
            if (sy[i] + sx[i] >= 0) {
                if (i == 0)
                    this.mm[sy[i]][sx[i]] = 2;
                else
                    this.mm[sy[i]][sx[i]] = 1;
            }
        }
        this.mm[ym][xm] = 3;
    }

    void init() {
        int y = this.mm.length;
        int x = this.mm[0].length;

        this.setBounds(40, 40, blockSize * (x + 1) + 40, blockSize * (y + 1) + 50 + 40);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.addKeyListener(new MyKeyBoardEvent(this));

        this.setLayout(null);
        Container conn = this.getContentPane();

        length = 3;
        this.showLength = new JLabel("Your snake is " + length + " blocks long");
        Font mf = new Font("Arial", Font.BOLD, 25);
        this.showLength.setFont(mf);
        this.showLength.setBounds(5, 10, 500, 30);
        conn.add(showLength);

        mainMap = new DrawPanel(blockSize, this);
        mainMap.setBounds(20, 50, blockSize * x + 20, blockSize * y + 20);
        conn.add(mainMap);

        this.setVisible(true);
    }

    void moveOn() {
        Operation move = new Operation(this);
        switch (this.direction) {
        case 'w':
            move.moveUp();
            break;

        case 'a':
            move.moveLeft();
            break;

        case 's':
            move.moveDown();
            break;

        case 'd':
            move.moveRight();
            break;

        default:
            break;
        }
    }
}