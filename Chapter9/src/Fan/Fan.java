package Fan;

public class Fan {
	final static int SLOW=1;
	final static int MEDIUM=2;
	final static int FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="blue";
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public boolean getON() {
		return on;
	}
	public void setON(boolean on) {
		this.on=on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public Fan() {
		
	}
	public String toString() {
		 if (on)
	            return "speed: " + speed + "\ncolor: " + color + "\nradius: " + radius;
	        else 
	            return "fan is off" + "\ncolor: " + color + "\nradius: " + radius;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fan f1=new Fan();
		Fan f2=new Fan();
		f1.setSpeed(FAST);
		f1.setRadius(10);
        f1.setColor("yellow");
        f1.setON(true);
        System.out.println(f1.toString());
        f2.setSpeed(MEDIUM);
		f2.setRadius(5);
        f2.setColor("blue");
        f2.setON(false);
        System.out.println(f2.toString());
	}
}
 
