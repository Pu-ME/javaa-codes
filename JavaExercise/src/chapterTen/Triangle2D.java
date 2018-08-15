package chapterTen;

import java.awt.geom.Line2D;

import demo1.MyPoint;

/*
 * @author putengfei
 * @created 2017-11-17
*/
public class Triangle2D {
	
	private MyPoint p1,p2,p3;
	//默认构造使用（0,0）（1,1）（2,5）三个点
	public Triangle2D() {
		p1=new MyPoint(0,0);		
		p2=new MyPoint(1,1);
		p3=new MyPoint(2,5);
	}
/*	//使用指定点
	public Triangle2D(double x1,double y1,double x2,double y2,double x3,double y3) {
		p1=new MyPoint(x1,y1);
		p2=new MyPoint(x2,y2);
		p3=new MyPoint(x3,y3);
	}*/
	
	//创建制定点
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
	    this.p1 = p1;
	    this.p2 = p2;
	    this.p3 = p3;
	  }
	//P1,P2,P3的get,set方法
	public MyPoint getP1() {
		return p1;
	}
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	public MyPoint getP2() {
		return p2;
	}
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}
	public MyPoint getP3() {
		return p3;
	}
	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	//获取三角形面积
	public double getArea() {
		double side1=p1.distance(p2);
		double side2=p1.distance(p3);		double side3=p2.distance(p3);
		double s=(side1+side2+side3)/2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	//获取三角形周长
	public double getPerimeter() {
		return p1.distance(p2)+p1.distance(p3)+p2.distance(p3);
	}
	//判断点是否在三角形内
	public boolean contains(MyPoint p) {
		double x=p.getX(),y=p.getY();
		double maxX = Math.max(p1.getX(), Math.max(p2.getX(), p3.getX()));
	    double minX = Math.min(p1.getX(), Math.min(p2.getX(), p3.getX()));
	    double maxY = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
	    double minY = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));
	    
	    if (x < minX || x > maxX || y < minY || y > maxY) {
	      return false;  // Outside the bounding rectangle of the triangle
	    }

	    Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	    Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
	    Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
	    
	    if (side1.contains(x, y) || side2.contains(x, y) || side3.contains(x, y)) {
	      return true; // On the border of the triangle 
	    }
	    
	    double topY = -10;
	    if (x == p1.getX()) {
	      topY = p1.getY();
	    } 
	    else if (x == p2.getX()) {
	      topY = p2.getY();
	    } 
	    else if (x == p3.getX()) {
	      topY = p3.getY();
	    } 
	    
	    Line2D line;
	    if (y < topY) 
	      line = new Line2D.Double(x, y, x, minY);
	    else  
	      line = new Line2D.Double(x, y, x, maxY);
	    
	    int hits = 0;
	    if (line.intersectsLine(side1))
	      hits++;
	    
	    if (line.intersectsLine(side2))
	      hits++;
	    
	    if (line.intersectsLine(side3))
	      hits++;
	    
	    if (hits % 2 == 0) 
	      return false;
	    else 
	      return true;
	}
	//判断指定三角形是否在这个三角形内
	public boolean contains(Triangle2D t) {
		 return contains(t.p1) && contains(t.p2) && contains(t.p3);
	}
	//判断两个三角形是否重叠
	public boolean overlaps(Triangle2D t) {
		 Line2D line1 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
		    Line2D line2 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
		    Line2D line3 = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());

		    Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		    Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
		    Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
		    
		    return contains(t) || t.contains(this) || 
		      line1.intersectsLine(side1) || 
		      line1.intersectsLine(side2) || 
		      line1.intersectsLine(side3) || 
		      line2.intersectsLine(side1) || 
		      line2.intersectsLine(side2) || 
		      line2.intersectsLine(side3) ||
		      line3.intersectsLine(side1) || 
		      line3.intersectsLine(side2) || 
		      line3.intersectsLine(side3);
	}
	
	
	public static void main(String[] args) {
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5,2),new MyPoint(4.2,3),new MyPoint(5,3.5));
		System.out.printf("Triangle Area: %.3f  \nTriangle Perimeter: %.3f\n",t1.getArea(),t1.getPerimeter());
		
		System.out.print("Point(3,3) in this triangle: ");
		System.out.println(t1.contains(new MyPoint(3,3)));
		System.out.print("new triangle in this triangle: ");
		System.out.println(t1.contains(new Triangle2D(new MyPoint(2.9,2),new MyPoint(4,1),new MyPoint(1,3.4))));
		System.out.print("new triangle  overlaps this triangle: ");
		System.out.println(t1.overlaps(new Triangle2D(new MyPoint(2,5.5),new MyPoint(4,-3),new MyPoint(2,6.5))));
	}
}



