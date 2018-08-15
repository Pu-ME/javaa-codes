package chapterEleven;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-11-24
*/
public class Fifteen {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the numbers of points: ");
		int numbers = in.nextInt();
		System.out.println("Enter the coodinates of the points:");
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		
		for(int i = 0; i < numbers; i++) {
			x.add(in.nextDouble());
			y.add(in.nextDouble());
		}
		
		double total = 0;
		 for (int i = 1; i < numbers- 1; i++) 
		      total += getArea(x.get(0), y.get(0), x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));
		      
		    System.out.print("The total area is " + total);
	}

	private static double getArea(Double x1, Double y1, Double x2, Double y2, Double x3,
			Double y3) {
			double s1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 -y2));
		    double s2 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 -y3));
		    double s3 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 -y2));
		      
		    double s = (s1 + s2 + s3) / 2;
		    return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
	}
}
