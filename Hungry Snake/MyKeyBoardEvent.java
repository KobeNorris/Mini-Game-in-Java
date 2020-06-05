import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class MyKeyBoardEvent extends KeyAdapter{
    int count = 0;
    HSMap map;

    MyKeyBoardEvent(HSMap map) {
        super();
        this.map = map;
    }

    @Override
    public void keyPressed(KeyEvent k) {
        //System.out.println("Keyboard in");
        super.keyPressed(k);
        if (k.getKeyChar() == 'w') {
            map.direction = 'w';
            map.repaint();
        } else if (k.getKeyChar() == 'a') {
            map.direction = 'a';
            map.repaint();
        } else if (k.getKeyChar() == 's') {
            map.direction = 's';
            map.repaint();
        } else if (k.getKeyChar() == 'd') {
            map.direction = 'd';
            map.repaint();
        }

        return;
    }
}