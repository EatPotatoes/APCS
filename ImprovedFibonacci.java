import java.util.Scanner;

public class ImprovedFibonacci 
{
	public static long[] nums = new long[50];
	public static int iterativeCount, recursiveCount, fastRecursiveCount = 0;
	
	public static void main(String[] args) 
	{
		for(int i = 0; i < nums.length; i++)
			nums[i] = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Input integer: ");
		int x = Integer.parseInt(scan.next());
		
		System.out.println(x + " | Iterative: " + fibonacci((long) x) + "| Loops: " + iterativeCount);
		System.out.println(x + " | Recursive: " + RecursiveFibonacci((long) x) + "| Recursive Runs: " + recursiveCount);
		System.out.println(x + " | Fast Recursive: " + FastRecursiveFibonacci((long) x) + "| Fast Recursive Runs: " + fastRecursiveCount);
	}
	
	/*
	 * The iterative method runs the loop a linear amount of times depending on the fibonacci number,
	 * and will always loop around the same amount of the value of the fibonacci number
	 * 
	 * The original recursive method runs the method a significantly larger amount of times,
	 * because each time it recomputes the value, which leads to more and more recursion
	 * depending on the scale of the fibonacci value desired
	 * 
	 * The new recursive method is pretty close to linear, because it stores the values for each 
	 * fibonacci number and references the value instead of recomputing and doing more
	 * recursion.
	 */

	public static long FastRecursiveFibonacci(long n)
	{
		fastRecursiveCount++;
		if(n <= 2)
		{
			if(nums[(int) n] == 0)
				nums[(int) n] = 1;
			return 1;
		}
		else
		{
			if(nums[(int) n - 1] == 0 || nums[(int) n - 2] == 0)
			{
				nums[(int) n] = FastRecursiveFibonacci(n - 2) + FastRecursiveFibonacci(n - 1);
				return nums[(int) n];
			}
			else
				return nums[(int) n - 2] + nums[(int) n - 1];
		}
	}
	
	public static long RecursiveFibonacci(long n)
	{
		//base case
		recursiveCount++;
		if( n <= 2)
		{
			return 1;
		}
		else
		{
			return RecursiveFibonacci(n -2) + RecursiveFibonacci(n - 1);
		}
	}
	
	public static long fibonacci (long n)
	{
		long f1 = 1;
		long f2 = 1;
		long f3 = -999;
		
		for( int i = 3; i <= n; i++)
		{
			iterativeCount++;
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		
		return f3;
	}
}
