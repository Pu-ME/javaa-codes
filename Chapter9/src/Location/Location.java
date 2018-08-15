package Location;

import java.util.Scanner;

public class Location {
	 public int  row;
	 public int  column;
	 public double maxValue;
	 public Location() {
		 row =0;
		 column=0;
		 maxValue=0;
	 }
	 public static Location locateLargest(double[][] a) {
		 Location location =new Location();
		 location.maxValue=a[0][0];
		 for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++) {
			if(location.maxValue<a[i][j]) { 
				location.maxValue=a[i][j];
				location.row=i;
				location.column=j;
			 }
			}
		 return location;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int row,column;
		
		System.out.print("Enter the number of rows and columns in the array:");
		row=input.nextInt();
		column=input.nextInt();
		double[][] a=new double[row][column];
		System.out.println("Enter the array:");
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++) {
				a[i][j]=input.nextDouble();
			}
		input.close();
		Location l =locateLargest(a);
       System.out.println("The location of the largest element is "+
		l.maxValue+" at ("+l.row+","+l.column+").");
	}

}
