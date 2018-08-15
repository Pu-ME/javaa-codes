package Eleven;

import java.util.ArrayList;
import java.util.Date;


public class Account {
	private int id=0;
	private double balance=0;
	private String name;
	private static double annualInterestRate=0;
	private Date dateCreated;
	ArrayList<Transaction> transaction=new ArrayList<Transaction>();
	
	public Account(String name,int id,double balance) {
		this.name=name;
		this.id=id;
		this.balance=balance;
		dateCreated=new Date();
	}
	public Account() {
		dateCreated=new Date();
	}
	
	public Account(int id,double balance) {
		this.id=id;
		this.balance=balance;
		dateCreated=new Date();
	}
	public ArrayList getTransaction() {
		return transaction;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id=id;
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
	public double getAnnualInterestRate() {
        return annualInterestRate;
    }
	public String getName() {
        return name;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = annualInterestRate / 12;
        return balance * monthlyInterestRate / 100;
	}
	
	public void withDraw(double money) {
        balance -= money;
        transaction.add(new Transaction('W',money,balance," "));
    }

    public void deposit(double money) {
        balance += money;
        transaction.add(new Transaction('D', money, balance, ""));
    }
}
