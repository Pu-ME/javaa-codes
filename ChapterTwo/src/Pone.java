import java.util.Scanner;

public class Pone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double POUNDSTOKG = 0.45359237;
		final double INCHESTOMETER = 0.0254;
		Scanner input=new Scanner(System.in);
		double kg,meter;
		double pounds,inches;
		double bmi;
		System.out.print("Enter weight in pounds:");
	    pounds=input.nextDouble();
	    System.out.print("Enter weight in inches:");
	    inches=input.nextDouble();
	    kg=pounds*POUNDSTOKG;
	    meter=inches*INCHESTOMETER;
	    bmi=kg/Math.pow(meter, 2);
		System.out.printf("BMI is %.4f",bmi);
		System.out.println();
		if(bmi<19.8)  
			System.out.println("You are thin!");
		else if(bmi>=18.5&&bmi<=23.9)
			System.out.println("You are normal!");
		else if(bmi>=24&&bmi<=27.9)
			System.out.println("You are fat!");
		else if(bmi>28.0)
			System.out.println("You are too fat!");
		
		input.close();
	}

}
