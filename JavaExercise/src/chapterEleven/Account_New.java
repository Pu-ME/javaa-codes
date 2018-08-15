package chapterEleven;

import java.util.ArrayList;
import java.util.Date;



/*
 * @author putengfei
 * @created 2017-12-01
*/
public class Account_New {
	private String name;
	private int id=0;
	private double balance=0;
	private static double annualInterestRate=0;
	private Date dateCreated;
	private ArrayList<Transaction> transaction = new ArrayList<>();
	
	public Account_New() {
		dateCreated = new Date();
	}
	public Account_New(String name,int id,double balance) {
		this.name=name;
		this.id=id;
		this.balance=balance;
		dateCreated=new Date();
	}
	
	public int getID() {
		return id;
	}
	public ArrayList<Transaction> getTransaction() {
		return transaction;
	}
	
	public void setID(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
		
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account_New.annualInterestRate = annualInterestRate;
    }
	public double getMonthlyInterest() {
		double monthlyInterestRate = annualInterestRate / 12;
        return balance * monthlyInterestRate / 100;
	}
	
	public void withDraw(double money) {
        balance -= money;
        transaction.add(new Transaction('W',money,balance,"取款 "));
    }

    public void deposit(double money) {
        balance += money;
        transaction.add(new Transaction('D',money,balance,"存款"));
    }
	
	

	public static void main(String[] args) {
		Account_New newaccount = new Account_New("Geogre",1122,1000);
		Account_New.setAnnualInterestRate(1.5);
		newaccount.deposit(30);
		newaccount.deposit(40);
		newaccount.deposit(50);
		newaccount.withDraw(5);
		newaccount.withDraw(4);
		newaccount.withDraw(2);
		
		System.out.println("Name: " + newaccount.getName());
	    System.out.println("Annual interest rate: " + Account_New.getAnnualInterestRate());
	    System.out.println("Balance: " + newaccount.getBalance());
	    
	    ArrayList list = newaccount.getTransaction();
	    
	    System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\t%-10s\t\n", "Date", "Type", "Amount", "Balance","Description");
	    
	    for (int i = 0; i < list.size(); i++) {
	      Transaction transaction = (Transaction)(list.get(i));
	      System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\t%-10s\t\n", transaction.getDate(), 
	          transaction.getType(), transaction.getAmount(), transaction.getBalance(),transaction.getDescription());
	    }
	}
}
