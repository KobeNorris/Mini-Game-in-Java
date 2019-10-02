package bird;

import pipeLine.*;

public class Bird {
	private final int maxHeight = 560;
	private final int minHeight = 35;
	private final int jumpHigh = 55;
	private final float g = 2f;
	private int height = 560;
	private int downSpeed = 0;
	private boolean dead = false;
	
	public void setHeight (int height) {
		this.height = height;
	}
	public int getHeight () {
		return height;
	}
	
	public void gravity () {
		this.downSpeed += g;
		if((height - minHeight) < downSpeed * 0.1) {
			height = minHeight;
		}else {
			height -= downSpeed * 0.1;
		}
		return;
	}
	
	public void flappy () {
		this.downSpeed = 0;
		
		if(height <= maxHeight - jumpHigh) {
			this.height += jumpHigh;
		} else {
			this.height = maxHeight;
		}
		return;
	}
	
	public boolean getState () {
		return dead;
	}
	
	public void hitPipe (Pipe[] pipeLine) {
		for(int t = 0; t < pipeLine.length; t++) {
			int up = pipeLine[t].getUpHeight();
        	int down = pipeLine[t].getDownHeight();
        	int position = pipeLine[t].getPosition();
			if(position <= 140 && 140 <= position + 35) {
				if(this.height >= up || this.height <= down + 40) {
					this.dead = true;
				}
			}
		}
	}
	
}