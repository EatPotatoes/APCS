import java.util.ArrayList;

public class BankAccountLister 
{

	public static void main(String[] args) 
	{
		BankAccount b1 = new BankAccount("John", 7);
		BankAccount b2 = new BankAccount("Bob", 12);
		BankAccount b3 = new BankAccount("Carter", 42);
		BankAccount b4 = new BankAccount("Allen", 98);
		BankAccount b5 = new BankAccount("Damien", 76);
		BankAccount b6 = new BankAccount("Edgar", 23);
		BankAccount b7 = new BankAccount("Francis", 59);
		BankAccount b8 = new BankAccount("Gerard", 66);
		BankAccount b9 = new BankAccount("Harold", 38);
		BankAccount b10 = new BankAccount("Isaac", 75);
		
		BankAccount[] x = new BankAccount[] {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);
		selectionSort(x);
		System.out.println("===================");
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		for (BankAccount acc : x)
		{
			accounts.add(acc);
		}
		
		SavingsAccount s1 = new SavingsAccount("Leroy", 10, 9);
		SavingsAccount s2 = new SavingsAccount("Leroy", 20, 8);
		SavingsAccount s3 = new SavingsAccount("Leroy", 30, 7);
		SavingsAccount s4 = new SavingsAccount("Leroy", 40, 6);
		SavingsAccount s5 = new SavingsAccount("Leroy", 50, 5);
		SavingsAccount s6 = new SavingsAccount("Leroy", 60, 4);
		SavingsAccount s7 = new SavingsAccount("Leroy", 70, 3);
		SavingsAccount s8 = new SavingsAccount("Leroy", 80, 2);
		
		SavingsAccount[] y = new SavingsAccount[] {s1, s2, s3, s4, s5, s6, s7, s8};
		
		for(int i = 0; i < y.length; i++)
			System.out.println(y[i]);
		selectionSort2(y);
		System.out.println("--------------");
		for(int i = 0; i < y.length; i++)
			System.out.println(y[i]);
		
	}
	
	public static void selectionSort (BankAccount[] numbers)
	   {
	      int min;
	      BankAccount temp;

	      for (int index = 0; index < numbers.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < numbers.length; scan++)
	            if (numbers[scan].compareTo(numbers[min]) < 0)
	               min = scan;

	         // Swap the values
	         temp = numbers[min];
	         numbers[min] = numbers[index];
	         numbers[index] = temp;
	      }
	   }
	
	public static void selectionSort2 (SavingsAccount[] numbers)
	   {
	      int min;
	      SavingsAccount temp;

	      for (int index = 0; index < numbers.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < numbers.length; scan++)
	            if (numbers[scan].compareTo(numbers[min]) < 0)
	               min = scan;

	         // Swap the values
	         temp = numbers[min];
	         numbers[min] = numbers[index];
	         numbers[index] = temp;
	      }
	   }
}

/**
 * 1. Explain why it is useful to implement the comparable interface as high in the inheritance as possible
 * 		Because when you do that, it automatically inherits the compareTo method for all the child classes.
 * 2. What happens in the savings account class when you also implement comparable at that level?
 * 		The driver seems to still work as intended.
**/
