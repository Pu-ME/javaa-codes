package MyStack;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
	    
	    MyStack stack = new MyStack();
	    
	    for (int i = 0; i < 5; i++)
	      stack.push(input.nextLine());
	    
	    System.out.println(stack.getSize() + " strings are: ");
	    while (!stack.isEmpty())
	      System.out.println(stack.pop());
	   
	   System.out.println(stack.toString());
	}

}
