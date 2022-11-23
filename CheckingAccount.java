
public class CheckingAccount extends BankAccount
{
	private int transactions;
	private final double TRANSACTION_FEE;
	
	public CheckingAccount(String name, double balance)
	{
		super(name, balance);
		transactions = 0;
		TRANSACTION_FEE = 5;
	}
	
	/**
	 * Deposits the amount into the bank account and increases the transaction count by 1
	 */
	public void deposit(double amount)
	{
		super.deposit(amount);
		transactions++;
	}
	
	/**
	 * Withdraws the amount from the bank account and increases the transaction count by 1
	 */
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		transactions++;
	}
	
	/**
	 * Deducts the fee from the bank account given the transaction count and constant fee
	 */
	public void deductFees()
	{
		this.withdraw(transactions * TRANSACTION_FEE);
	}
	
	/**
	 * returns the transaction count
	 * @return transaction count
	 */
	public int getTransactionCount()
	{
		return transactions;
	}
	
	public String toString()
	{
		String result = super.toString();
		result = result + "\nTransactions: " + transactions;
		return result;
	}
}
