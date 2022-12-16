import java.util.ArrayList;

public class driver 
{
	public static void main(String[] args) 
	{
		ArrayList <BankAccount> accs = new ArrayList <BankAccount>();
		
		accs.add(new CheckingAccount("CA 1", 0));
		accs.add(new SavingsAccount("SA 1", 0, 1));
		accs.add(new CheckingAccount("CA 2", 0));
		accs.add(new SavingsAccount("SA 2", 0, 2));
		accs.add(new CheckingAccount("CA 3", 0));
		accs.add(new SavingsAccount("SA 3", 0, 3));
		accs.add(new CheckingAccount("CA 4", 0));
		accs.add(new SavingsAccount("SA 4", 0, 4));
		
		double total = 0;
		for(int i = 0; i < accs.size(); i++)
		{
			System.out.println(accs.get(i).toString());
			accs.get(i).deposit(100);
			total = total + accs.get(i).getBalance();
		}
		System.out.println("Total before deduction(Checking) and interest adding(Savings): " + total);
		
		System.out.println("========");
		
		total = 0;
		double totalFees = 0;
		double totalInterest = 0;
		for(int i = 0; i < accs.size(); i++)
		{
			if(i % 2 == 0)
			{
				((CheckingAccount) accs.get(i)).deductFees();
				totalFees = totalFees + 100 - accs.get(i).getBalance();
			}
			else
			{
				((SavingsAccount) accs.get(i)).addInterest();
				totalInterest = totalInterest - 100 + accs.get(i).getBalance();
			}
			total = total + accs.get(i).getBalance();
		}
		System.out.println("Total fees deducted from checking: $" + totalFees);
		System.out.println("Total interest added from savings: $" + totalInterest);
		System.out.println("Total Balance of all accounts: $" + total);
	}

}
