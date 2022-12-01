// SavingsAccount.java

/**
 * 
 * Simulates a savings account on which interest can
 * 			be earned.
 * @author Steinberg
 * @version July 23, 2007
 * 
 */

public class SavingsAccount extends BankAccount implements Comparable
{
	private double interestRate;

	/**
	 * Constructs a savings account from 
	 * 	a customer name, an initial balance, and an
	 * 	interest rate.
	 * @param name customer's name
	 * @param balance initial balance
	 * @param rate interest rate	
	 */
	public SavingsAccount(String name, double balance, double rate)
	{
		super(name, balance);
		interestRate = rate;
	}
	
	/**
	 * Adds interest to the balance using the interest rate.
	 */
	public void addInterest()
	{
		double current;
		current = this.getBalance();
		this.deposit(interestRate*current);
	}

	public String toString()
	{
		String result = super.toString();
		result = result + "\nInterest Rate: " + interestRate;
		
		return result;
	}
	
	//Exercise 4
	public int compareTo(Object arg0) 
	{
		SavingsAccount acc = (SavingsAccount) arg0;
		if(this.interestRate == acc.interestRate)
			return 0;
		else if(this.interestRate > acc.interestRate)
			return 1;
		else
			return -1;
	}
}
