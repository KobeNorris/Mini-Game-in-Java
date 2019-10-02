import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyJpanel extends JFrame{
    PicJpanel pj;
    int map[][] = new int [15][15];
    int flag = 2;
    int winer=0;

    public MyJpanel(){
        init(); // Initialise the board
    }
    private void init(){
        // Window settings				
            this.setSize(760, 790);     // Have to match the size of the pic                        			
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  		
            this.setLocationRelativeTo(null);                   			
            this.setResizable(false);                           
            this.setLayout(null);                              		
            this.setTitle("5 seeds game");  				            
            
            pj = new PicJpanel(this);
            pj.addMouseListener(new MyMouse(this));
            this.add(pj);
            
            this.setVisible(true);
    }
    public static void main(String[] args){
        new MyJpanel();
    }
}



class PicJpanel extends JPanel{
    MyJpanel mj;
    public PicJpanel(MyJpanel mj){
        this.setBounds(0,0,mj.getWidth(),mj.getHeight());
        this.mj = mj;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            BufferedImage bi = ImageIO.read(new File("background.jpg"));
			g.drawImage(bi, 0, 0, this);
        } catch (IOException e){
            e.printStackTrace();
        }


        g.setColor(Color.BLACK);
        for (int i = 0; i < 15; i++) {			
            for (int j = 0; j < 15; j++) {
                g.setColor(Color.BLACK);			
                g.drawRect(50 * i, 50 * j, 50, 50);

                if(mj.map[i][j] == 1){
                    g.setColor(Color.WHITE);
                    g.fillOval(50 * j + 6, 50 * i + 6, 38, 38);
                }
                else if(mj.map[i][j] == 2){
                    g.setColor(Color.BLACK);
                    g.fillOval(50 * j + 6, 50 * i + 6, 38, 38);
                }						
            }		
        }
    }
}


class MyMouse extends MouseAdapter {	
    MyJpanel mj;

    public MyMouse(MyJpanel mj) {
        super();
        this.mj = mj;
    }

    // @Override
    public void mousePressed(MouseEvent e) {
        if(mj.winer!=0){
			mj.map = new int[15][15];
			mj.winer=0;
			mj.pj.repaint();
			return;
		}

        Point p = e.getPoint();
        int x = (int) p.getX() / (750 / 15);			
        int y = (int) p.getY() / (750 / 15);			
        // System.out.println("x=" + p.getX() + "   y=" + p.getY());			
        // System.out.println("x=" + x + "   y=" + y);

        if (mj.map[y][x] == 0) {
            mj.map[y][x] = mj.flag;
        }

        if(mj.flag == 1){
            mj.flag = 2;
        }else{
            mj.flag = 1;
        }
        
        if(isWin(x, y, mj.map)){
            // System.out.println(mouse.isWin(y, x, mj.map));			
            if(mj.map[y][x]==1){				
                mj.winer=1;				
                mj.pj.repaint();					
                JOptionPane.showMessageDialog(mj, "White wins");				
                mj.flag=2;			
            }
            if(mj.map[y][x]==2){				
                mj.winer=2;				
                mj.pj.repaint();				
                JOptionPane.showMessageDialog(mj, "Black wins");							
                mj.flag=2;			
            }
        }
        
        mj.pj.repaint();
    }

    protected static boolean isWin(int x, int y, int[][] map){
        int count = 0;
        int flag = 0;

        for(int i = y - 4, j = x; i < y + 5; i++) {//Vertical line
            // System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(i < 0 || i >= 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                // System.out.println(map[i][j] + "--" + map[y][x] + "--1");
                // System.out.println("Yes1 " + count);
                if(count >= 5){
                    flag = 1;
                    return true;
                }
            }
        }
        count = 0;
        // System.out.println();

        for(int i = y, j = x - 4; j < x + 5; j++) {//Horizontal line
            // System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(j < 0 || j >= 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                // System.out.println(map[i][j] + "--" + map[y][x] + "--2");
                // System.out.println("Yes2 " + count);
                if(count >= 5){
                    flag = 1;
                    return true;
                }
            }
        }
        count = 0;
        // System.out.println();

        for(int i = y - 4, j = x + 4; j > x - 5; j--, i++) {//Leftup 2 rightbutt line :)
            // System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(i < 0 || i >= 15 || j < 0 || j >= 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                // System.out.println(map[i][j] + "--" + map[y][x] + "--3");
                // System.out.println("Yes3 " + count);
                if(count >= 5){
                    flag = 1;
                    return true;
                }
            }
        }
        count = 0;
        // System.out.println();

        for(int i = y + 4, j = x + 4; j > x - 5; j--, i--) {//Leftbutt 2 rightup line :)
            // System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(i < 0 || i >= 15 || j < 0 || j >= 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                // System.out.println(map[i][j] + "--" + map[y][x] + "--4");
                // System.out.println("Yes4 " + count);
                if(count >= 5){
                    flag = 1;
                    return true;
                }
            }
        }
        
        return false;
    }
}