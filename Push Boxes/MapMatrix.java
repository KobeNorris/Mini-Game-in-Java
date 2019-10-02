import java.util.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class MapMatrix {
    public int [][] mm;
    int x, y;

    public MapMatrix(){
        int mx, my, num;
        Scanner input = new Scanner(System.in);
        System.out.print("Please input x's and y's values: ");
        x = input.nextInt();
        y = input.nextInt();
        System.out.print("Please input the number of boxes: ");
        num = input.nextInt();
        if(x * y <= 2 * num){
            System.out.println("Too many boxes!");
            System.exit(0);
        } else {
            mm = new int [y][x];

            for(int i = 0; i < num; i++){
                mx = (int)(Math.random() * (x - 2) + 1);
                my = (int)(Math.random() * (y - 2) + 1);
                while(true){
                    if(mm[my][mx] == 0){
                        mm[my][mx] = 1;
                        break;
                    } else {
                        mx = (int)(Math.random() * (x - 2) + 1);
                        my = (int)(Math.random() * (y - 2) + 1);
                    }
                }
                while(true){
                    if(mm[my][mx] == 0){
                        mm[my][mx] = 2;
                        break;
                    } else {
                        mx = (int)(Math.random() * x);
                        my = (int)(Math.random() * y);
                    }
                }
                // System.out.println("Now is " + i);
            }
            mx = (int)(Math.random() * x);
            my = (int)(Math.random() * y);
            while(true){
                if(mm[my][mx] == 0){
                    mm[my][mx] = 3;
                    break;
                } else {
                    mx = (int)(Math.random() * x);
                    my = (int)(Math.random() * y);
                }
            }
        }
        input.close();
    }

    public void playGame(){
        
    }
}