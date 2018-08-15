package chapterEleven;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author putengfei
 * @created 2017-11-24
*/
public class Sixteen {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int number1 = (int)(Math.random()*10);
		int number2 = (int)(Math.random()*10);
		int answer;
		System.out.println("What is " + number1 + " + " + number2 +"?");
		answer = in.nextInt();
		list.add(answer);
		while(number1 + number2 !=answer) {
			System.out.print("Wrong answer, Try again.");
			System.out.println("What is " + number1 + " + " + number2 +"?");
			
			answer=in.nextInt();
			
			if(list.contains(answer)) {
				 System.out.println("You already entered " + answer);
			}
			else {
				 list.add(answer);
			}
		}
		
		System.out.println("You got it!");
	}
}
