package LinearEquation;

import java.util.Scanner;

public class LinearEquation {
	private double a,b,c,d,e,f;
	public LinearEquation(double a,double b,double c,double d,double e,double f) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
	public double getF() {
		return f;
	}
	public boolean isSolvable() {
		if((a*d-b*c)!=0) return true;
		else return false;
	
	}
	public double getX() {
		return ((e*d-b*f)/(a*d-b*c));
	}
	public double getY() {
		return ((a*f-e*c)/(a*d-b*c));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		double a,b,c,d,e,f;
		System.out.print("Enter a,b,c,d,e,f:");
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		d=input.nextDouble();
		e=input.nextDouble();
		f=input.nextDouble();
		input.close();
		LinearEquation lin=new LinearEquation(a, b, c, d, e, f);
		if(lin.isSolvable()) 
			System.out.println("x is "+lin.getX()+" and y is "+lin.getY());
		else System.out.println("The equation has no solution");
	}

}
