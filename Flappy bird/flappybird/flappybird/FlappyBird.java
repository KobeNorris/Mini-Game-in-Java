package flappybird;

import fbstage.*;
//import bird.Bird;
import pipeLine.Pipe;

public class FlappyBird {
	
	public static void main(String[] args) {
		FBStage myStage = new FBStage("Kobe's flappy bird");
		myStage.init();
		
		MyThread myThread = new MyThread(myStage);
		myThread.start();
	}
}

class MyThread extends Thread {
	FBStage myStage;
	int distance;

    MyThread(FBStage myStage) {
        this.myStage = myStage;
    }

    @Override
    public void run() {
        while (true) {
        	myStage.myBackGround.mybird.gravity();
        	pipeMove(myStage.myBackGround.pipeLine);
        	myStage.myBackGround.mybird.hitPipe(myStage.myBackGround.pipeLine);
        	myStage.increaseDistance();
        	myStage.distanceShow.setText("You have flied for " + myStage.distance + " M");
        	myStage.repaint();
            try {
                sleep(10); // Sleep for 0.01 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(myStage.myBackGround.mybird.getState() == true)
            	break;
        }
        distance = myStage.getDistance();
        System.out.println("Game over, you have flied " + distance + " M");
    }
    
    public void pipeMove(Pipe[] pipeLine) {
    	for(int t = 0; t < pipeLine.length; t++) {
    		int position = pipeLine[t].getPosition();
    		if(position <= 0) {
    			pipeLine[t] = new Pipe(900 + pipeLine.length * 100);
    		} else {
    			pipeLine[t].move();
    		}
    	}
    }
}