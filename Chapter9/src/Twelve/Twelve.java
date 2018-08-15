package Twelve;
import java.util.Scanner;
import LinearEquation.LinearEquation;

public class Twelve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		double x1,x2,x3,x4,y1,y2,y3,y4;
		System.out.print("Enter x1,y1,x2,y2,x3,y3,x4,y4:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		x4=input.nextDouble();
		y4=input.nextDouble();
		input.close();
		double a=y1-y2;
		double b=-(x1-x2);
		double c=y3-y4;
		double d=-(x3-x4);
		double e=(y1-y2)*x1-(x1-x2)*y1;
		double f=(y3-y4)*x3-(x3-x4)*y3;
		LinearEquation linear=new LinearEquation(a,b,c,d,e,f);
		if(linear.isSolvable())  
			System.out.println("The intercsetcing point is at ("+linear.getX()+","+linear.getY()+")");
		else System.out.println("The two lines are parallel");
		
	}

}
