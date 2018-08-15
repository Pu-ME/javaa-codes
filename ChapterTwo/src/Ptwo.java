import java.util.Scanner;

public class Ptwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		final double annualInterestRate = 5;
		double amount;
		double monthlyInterestRate=annualInterestRate/1200;
		System.out.print("Enter the monthly saving amount:");
		amount=input.nextDouble();
		double sum=0.0;
		for(int i=0;i<6;i++)
			sum=(sum+amount)*(1+monthlyInterestRate);
			System.out.printf("After the sixth monthly,the account value is %.3f",sum);

	}

}
