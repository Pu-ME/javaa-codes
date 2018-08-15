package QuadraticEquation;
import java.util.Scanner;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	public QuadraticEquation(double a,double b,double c) {
		this.a=a;
		this.b=b;
		this.c=c;
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
	public double getDiscriminant() {
		return Math.pow(b,2)-4*a*c;
	}
	public double getRoot1() {
		if (this.getDiscriminant()>=0) 
			return (-b+Math.pow(b*b-4*a*c, 0.5))/(2*a);
		else return 0;
	}
	public double getRoot2() {
		if (this.getDiscriminant()>=0) 
			return (-b-Math.pow(b*b-4*a*c, 0.5))/(2*a);
		else return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		double a,b,c;
		System.out.print("Enter a,b,c:");
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		input.close();
		QuadraticEquation qua=new QuadraticEquation(a,b,c);
		if (qua.getDiscriminant()>0)
			System.out.println("The equation has two roots "+qua.getRoot1()+" and "+qua.getRoot2());
		else if(qua.getDiscriminant()==0)
			System.out.println("The equation has one root "+qua.getRoot1());
		else System.out.println("The equation has no real roots");
	}

}