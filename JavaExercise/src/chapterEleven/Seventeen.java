package chapterEleven;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-11-24
*/
public class Seventeen {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list =new ArrayList<Integer>();
		System.out.print("Enter an integer m:");
		int m = in.nextInt();
		
		int number = m ;
		int factor = 2;
		while(factor <= number ) {
			if(number % factor == 0) {
				list.add(factor);
				number = number / factor;
			}
			else {
				factor++;
			}
		}
		int n=1,i=0;
		while(i < list.size()-1) {
			if(list.get(i)!=list.get(i+1)) {
				n = n * list.get(i);
				i++;
			}
			else {
				i=i+2;
			}
		}
		
		if(i==list.size()-1) {
			n=n*list.get(i);
		}
		
		System.out.println("The smallest number n for m*n to be a perfect square is "+ n);
		System.out.println("m * n is "+(m*n));
	}
}
