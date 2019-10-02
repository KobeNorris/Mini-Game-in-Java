import java.util.*;
import java.awt.*;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class PushBoxes{

    public static void main(String[] args){
        GameMap map = new GameMap("Kobe's boxes pusher");
        MapMatrix mapMatrix = new MapMatrix();
        // for(int i = 0; i < mapMatrix.y; i++){
        //     for(int j = 0; j < mapMatrix.x; j++)
        //         System.out.print(mapMatrix.mm[i][j]);
        //     System.out.println();
        // }
        
        map.init(mapMatrix.mm);

        return;
    }
}

class GameMap extends JFrame {
    int blockSize = 80;
    JLabel showTime;
    DrawPanel mainMap;
    int[][] mm;
    GameMap(String title){
        super(title);
    }
    void init(int[][] mm) {
        this.mm = mm;
        int y = mm.length;
        int x = mm[0].length;

        this.setBounds(40,40,blockSize * (x + 1),50 + blockSize * (y + 1));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(new MyKeyBoardEvent(this));
        this.setLayout(null);
        Container conn = this.getContentPane();

        this.showTime = new JLabel("You have used 0 step");
        Font mf = new Font("Arial", Font.BOLD, 25);
        this.showTime.setFont(mf);
        this.showTime.setBounds(5,10,400,30);
        conn.add(showTime);

        // System.out.println("Yes");
        mainMap = new DrawPanel(blockSize,mm);
        mainMap.setBounds(20,50,blockSize * x + 20,blockSize * y + 20);
        // mainMap.addKeyListener(new MyKeyBoardEvent(mainMap));
        conn.add(mainMap);

        this.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    int blockSize;
    int[][] mm;
    int result;
    HSMap map;


    DrawPanel(int blockSize, HSMap map) {
        this.blockSize = blockSize;
        this.map = map;
        this.result = 0;
    }
    public void paintComponent(Graphics g){
        int y = mm.length;
        int x = mm[0].length;

        g.setColor(Color.DARK_GRAY);
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                g.setColor(Color.BLACK);
                g.drawRect(blockSize * i, blockSize * j,blockSize,blockSize);
                if(mm[j][i] == 1){ // Box
                    g.setColor(Color.ORANGE);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5,blockSize - 10,blockSize - 10);
                } else if(mm[j][i] == 2){ // Hole
                    g.setColor(Color.BLUE);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5,blockSize - 10,blockSize - 10);
                } else if(mm[j][i] == 3){ // Player
                    g.setColor(Color.RED);
                    g.fillOval(blockSize * i + 10, blockSize * j + 10,blockSize - 20,blockSize - 20);
                } else if(mm[j][i] == 4){ // Player on hole
                    g.setColor(Color.BLUE);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5,blockSize - 10,blockSize - 10);
                    g.setColor(Color.RED);
                    g.fillOval(blockSize * i + 10, blockSize * j + 10,blockSize - 20,blockSize - 20);
                } else if(mm[j][i] == 5){ // Box on hole
                    g.setColor(Color.YELLOW);
                    g.fillRect(blockSize * i + 5, blockSize * j + 5,blockSize - 10,blockSize - 10);
                }
            }
        }
    }
}