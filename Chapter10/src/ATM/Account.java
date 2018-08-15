package ATM;
import java.util.Date;
 public class Account {
		private int id=0;
		private double balance=0;
		private static double annualInterestRate=0;
		private Date dateCreated;
		
		public Account() {
			dateCreated=new Date();
		}
		
		public Account(int id,double balance) {
			this.id=id;
			this.balance=balance;
			dateCreated=new Date();
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

	    public void setAnnualInterestRate(double annualInterestRate) {
	        Account.annualInterestRate = annualInterestRate;
	    }
		public double getMonthlyInterestRate() {
			double monthlyInterestRate = annualInterestRate / 12;
	        return balance * monthlyInterestRate / 100;
		}
		
		public void withDraw(double money) {
	        balance -= money;
	    }

	    public void deposit(double money) {
	        balance += money;
	    }
}
