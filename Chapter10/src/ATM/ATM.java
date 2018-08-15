package ATM;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Account []account=new Account[10];
		for(int i=0;i<10;i++) {
			account[i]=new Account(i,100);
		}
		int id,choice;
		double amount,deposit;
		while (true) {
		System.out.print("Enter an id:");
		id=input.nextInt();
		if(id>=0&&id<10) {
			while(true) {
				System.out.println("Main Menu");
				System.out.println("1:check balance");
				System.out.println("2:withdraw");
				System.out.println("3:deposit");
				System.out.println("4:exit");
				System.out.print("Enter a choice:");
				choice=input.nextInt();
				switch(choice) {
					case 1: System.out.println("The balance is "+account[id].getBalance());
							break;
					case 2: System.out.print("Enter an amount to withdraw:");
						 	amount=input.nextDouble();
							account[id].withDraw(amount);
							break;
					case 3:System.out.print("Enter an amount to deposit:");
						   deposit=input.nextDouble();
						   account[id].deposit(deposit);
						   break;
					case 4: break;
						
				}
				if(choice==4) break;
			}
			
		}	
		else System.out.println( id+" is incorrect id");
		}
	}

}
