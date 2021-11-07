package in.conceptarchitect.finance;

import java.util.Scanner;

import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidCredentialsException;
import in.conceptarchitect.finance.exceptions.InvalidDenominationException;

public abstract class BankAccount implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int accountNumber;
	private String name;
	private String password;
	protected double balance;
	
	
	
	
	public BankAccount(int accountNumber, String name, String password, double amount) {
		
		balance=amount; //this is optional here as there is a single balance in the context	
		this.name=name;
		setPassword(password);		
		this.accountNumber=accountNumber;
		
	}
	
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	//account number can't be changed
	//public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public double getBalance() {
		return balance;
	}

	
	
	

	//should there be a getPassword and setPassword
	
//	public String getPassword() {
//		return password;
//	}
	
	
	void setPassword(String password) {
		
		this.password = salt(password);
	}
	
	
	public void changePassword(String oldPassword, String newPassword) {
		authenticate(oldPassword);
		setPassword(newPassword);
	}
	

	

	private String salt(String password) {
		
		String salted="";
		
		for(int i=0;i<password.length();i++) {
			int ch= (int) password.charAt(i);
			salted+=Integer.toHexString(ch);
		}
		return salted;
	}


	
	public void show() {
		System.out.println("account number\t"+accountNumber);
		System.out.println("name         \t"+name);
		System.out.println("password     \t"+password);
		System.out.println("balance      \t"+balance);
		//System.out.println("interest rate\t"+Bank.getInterestRate());
		System.out.println();
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s #%d\t%d\t%s\n", this.getClass().getSimpleName(), accountNumber, (int)balance, name);
	}

	public void deposit(double amount,String date,String description) {
		// TODO Auto-generated method stub
		Transaction t1=new Transaction();
		validateDenomination(amount);
		balance+=amount;
		date=t1.getDate();
		description=t1.getDescription();
		
	}
	
	
	public void authenticate(String password) {
		if( !this.password.equals(salt(password)))
			throw new InvalidCredentialsException(accountNumber);
		
		//No error here
	}

	protected void validateDenomination(double amount) {
		if(amount<=0)
			throw new InvalidDenominationException(accountNumber, "Amount Must be a Positive Value");
	}
	
	
	protected abstract double getMaxWithdrawAmount(); //{ return balance ;}
	
	
	private void ensureFunds(double amount) {
		double max=getMaxWithdrawAmount();
		if (amount>max) {
			throw new InsufficientBalanceException(accountNumber, amount-max);
		}
	}
	
	
	public void withdraw(double amount, String password,String date,String description) {
		
		validateDenomination(amount);
		
		ensureFunds(amount); 

		authenticate(password);
			
		balance-=amount;	
		
		Transaction t1=new Transaction(date,description);
		
		date=t1.getDate();
		description=t1.getDescription();
		
	}

	

	
	public void creditInterest(double interestRate) {
		balance+=(balance*interestRate/1200);
	}



	public void setAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber=accountNumber;
	}

}
