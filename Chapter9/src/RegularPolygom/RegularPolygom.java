package RegularPolygom;

public class RegularPolygom {

	private int n=3;
    private double side=1;
    private double x=0;
    private double y=0;
    
    public  RegularPolygom() {
    	
    }
    public RegularPolygom(int n,double side) {
    	this.n=n;
    	this.side=side;
    }
    
    public RegularPolygom(int n,double side,double x,double y){
    	this(n,side);
    	this.x=x;
    	this.y=y;
    }
    public int getN() {
    	return n;
    }
	public void setN(int n) {
		this.n=n;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side=side;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x=x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y=y;
	}
	public double getPerimeter() {
		return n*side;
	}
	public double getArea() {
		return (n*Math.pow(side, 2))/(4*Math.tan(Math.PI/n));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularPolygom r1=new RegularPolygom();
		RegularPolygom r2=new RegularPolygom(6,4);
		RegularPolygom r3=new RegularPolygom(10,4,5.6,7.8);
		
		System.out.println("r1 area: "+r1.getArea()+"\nr1 perimeter:"+r1.getPerimeter());
		System.out.println("r2 area: "+r2.getArea()+"\nr2 perimeter:"+r2.getPerimeter());
		System.out.println("r3 area: "+r3.getArea()+"\nr3 perimeter:"+r3.getPerimeter());
	}

}
