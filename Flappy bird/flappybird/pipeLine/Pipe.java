package pipeLine;

public class Pipe {
	
	private int width = 10;
	private int upHeight;
	private int downHeight;
	private int position;
	
	public Pipe(int position) {
		this.position = 800 - width;
		this.downHeight = ((int) (Math.random() * 300)) + 25;
		this.upHeight = this.downHeight + 200;
		
		this.position = position;
	}
	
	public void move() {
		this.position -= 5;
	}
	
	public int getUpHeight() {
		return upHeight;
	}
	
	public int getDownHeight() {
		return downHeight;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void getString() {
		System.out.println("upHeight: " + this.upHeight + " downHeight: " + this.downHeight + " position: " + this.position);
	}
}