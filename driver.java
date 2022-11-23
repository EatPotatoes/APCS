
public class driver 
{

	public static void main(String[] args) 
	{
		BankAccount ba = new BankAccount("John", 100);
		SavingsAccount sa = new SavingsAccount("Bob", 500, 0.01);
		CheckingAccount ca = new CheckingAccount("Alfred", 1000);
		
		
		System.out.println("BA balance before withdraw: " + ba.getBalance());
		System.out.println("Try to withdraw -$10 from BA");
		ba.withdraw(-10);
				
		System.out.println("SA balance before withdraw: " + sa.getBalance());
		System.out.println("Try to withdraw -$50 from SA");
		sa.withdraw(-50);
		
		
		
		System.out.println(ba.toString());
		System.out.println("-----");
		System.out.println(sa.toString());
		
		System.out.println("Savings is instance banking object: " + (sa instanceof BankAccount));
		System.out.println("Banking is instance of savings object: " + (ba instanceof SavingsAccount));
		
		
		System.out.println("Checking account balance: " + ca.getBalance());
		System.out.println("Depositing 5$, withdrawing 20$");
		ca.deposit(5);
		ca.withdraw(20);
		System.out.println("Amount before deducting fees: " + ca.getBalance());
		System.out.println("Number of transactions: " + ca.getTransactionCount());
		ca.deductFees();
		System.out.println("Balance after fee deduction: " + ca.getBalance());
	}

}
