package demo1;
/*
 * @author putengfei
 * @created 2017-11-22
*/
public class MyPoint{
	private double x,y;
	public MyPoint() {
		this(0,0);	
	}
	public MyPoint(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double distance(MyPoint p) {
		return Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));
	}
	public double distance(double x,double y) {
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
	
}
