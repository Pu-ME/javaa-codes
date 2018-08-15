package ShowPrimeFactor;
import java.util.Scanner;
import  Practice.StackOfIntegers;

public class ShowPrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOfIntegers stack=new StackOfIntegers();
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an integer:");
		int num=input.nextInt();
		input.close();
		System.out.println("The factor for "+num+" is:");
		int factor=2;
		while(factor<=num) {
			if(num%factor==0) {
				num=num/factor;
				stack.push(factor);
			}
			else factor++;
		}
		while(!stack.empty())
			System.out.print(stack.pop()+" ");
		
	}
	
	

}
