package fbstage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import background.*;

public class FBStage extends JFrame {
    public BackGround myBackGround;
    public JLabel distanceShow;
    
    public int distance = 0;

    public FBStage(String title) {
        super(title);
    }

    public void init() {
        this.setBounds(50, 40, 920, 740);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(null);

        myBackGround = new BackGround(this);
        this.add(myBackGround);
        
        distanceShow = new JLabel("You have flied for " + distance + " M");
        Font mf = new Font("Arial", Font.BOLD, 25);
        this.distanceShow.setFont(mf);
        this.distanceShow.setBounds(300, 10, 500, 30);
        this.add(distanceShow);
        
        
        this.addKeyListener(new MyKeyBoardEvent(this));

        this.setVisible(true);
    }
    
    public void increaseDistance() {
    	this.distance++;
    }
    
    public int getDistance() {
    	return distance;
    }
}

class MyKeyBoardEvent extends KeyAdapter{
     FBStage myStage;

    MyKeyBoardEvent(FBStage myStage) {
        super();
        this.myStage = myStage;
    }

    @Override
    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        if (k.getKeyChar() == ' ') {
            myStage.myBackGround.mybird.flappy();
        }
        
        else if(k.getKeyChar() == 'p') {
        	
        }

        return;
    }
}