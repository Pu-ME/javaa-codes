package Eleven;

import java.util.ArrayList;

public class Test {
	public static void main (String[] args) {
	    Account account =new Account("George",1122,1000);
	    account.setAnnualInterestRate(1.5);
	    account.deposit(30);
	    account.deposit(40);
	    account.deposit(50);
	    
	    account.withDraw(5);
	    account.withDraw(4);
	    account.withDraw(2);
	    
	    System.out.print("Name:"+account.getName());
	    System.out.println();
	    System.out.print("AnnualInterestRate:"+account.getAnnualInterestRate());
	    System.out.println();
	    System.out.print("Balance:"+account.getBalance());
	    System.out.println();
	    
	    ArrayList list =account.getTransaction();
	    System.out.printf("%-35s%-15s%-15s%-15s\n", "Date", "Type", "Amount", "Balance");
	    for (int i = 0; i < list.size(); i++) {
	        Transaction transaction = (Transaction)(list.get(i));
	        System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), 
	            transaction.getType(), transaction.getAmount(), transaction.getBalance());
	      }
	}
}
