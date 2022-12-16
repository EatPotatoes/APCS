/**
 * @author rsteinberg
 * @date	12/14/16
 * 
 * 3 different versions of bubble sort are shown in this class.
 */
import java.util.Random;

public class BubbleSort
{
	private static int count1 = 0;
	private static int count2 = 0;
	private static int count3 = 0;
	
	public static void main(String[] args)
	{
		int arraysize = 10;
		
		int[] bs1 = new int[arraysize];
		int[] bs2 = new int[arraysize];
		int[] bs3 = new int[arraysize];
		
		Random rnd = new Random();
		
		for( int i = 0; i < arraysize; i++)
		{
			bs1[i] = bs2[i] = bs3[i] = rnd.nextInt(arraysize);
		}
		
		System.out.println("========[ original array ]=======================\n");
		
		for( int i = 0; i < bs1.length; i++)
		{
			System.out.print(bs1[i] + " ");
		}
		
		System.out.println("\n\n========[ bs1 ]==================================\n");
		
		bs1 = bubbleSort1( bs1 );
		
		for( int i = 0; i < bs1.length; i++)
		{
			System.out.print(bs1[i] + " ");
		}
		System.out.println("\n\n========[ bs2 ]==================================\n");
		
		bs2 = bubbleSort2( bs2 );
		
		for( int i = 0; i < bs2.length; i++)
		{
			System.out.print(bs2[i] + " ");
		}
		System.out.println("\n\n========[ bs3 ]==================================\n");
		
		bs3 = bubbleSort3( bs3 );
		
		for( int i = 0; i < bs3.length; i++)
		{
			System.out.print(bs3[i] + " ");
		}
		
		System.out.println("\nbs1 operations: " + count1);
		System.out.println("bs2 operations: " + count2);
		System.out.println("bs3 operations: " + count3);
		
		System.out.println("The slowest algorithm took " + Math.max(count1, Math.max(count2, count3)) + " comparisons");
		
		System.out.println("The most efficient algorithm took " + Math.min(count1, Math.min(count2, count3)) + " comparisons");
		
		System.out.println("BS1 and BS2 are about the same efficiency, but BS3 takes almost double the time");
		
		System.out.println("BS2 and BS3 take 100 and 190 comparisons every time, respectively, \nbecause the for loops are hard coded to the length of the array");
		
		System.out.println("BS1 takes anywhere from 80-105 comparisons (occasional outliers lower and higher), \nbecause it is based on the status of the array");
	
		System.out.println("BS1 is more efficient because it does not depend on status of array");
		System.out.println("An unlucky set of numbers will lead to more comparisons, but a good set could lead to less");
		
		System.out.println("THIS ANALYSIS ONLY INCLUDES COMPARISONS AND NOT DATA MOVEMENT");
		
		System.out.println("Further data in comments of code below the main");
	}
	
	/*
	 * Format: (bs1 comparisons, bs2 comparisons, bs3 comparisons)
	 * Trial 1: 91, 100, 190
	 * Trial 2: 96, 100, 190
	 * Trial 3: 91, 100, 190
	 * Trial 4: 84, 100, 190
	 * Trial 5: 96, 100, 190
	 * Trial 6: 96, 100, 190
	 * Trial 7: 64, 100, 190
	 * Trial 8: 75, 100, 190
	 * Trial 9: 75, 100, 90
	 * Trial 10: 84, 100, 90
	 */
	
	/**
	 * bubbleSort1 uses the bubblesort algorithm to put an 
	 * array in order from least to greatest
	 * @param int[] the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort1( int arr[])
	{
		boolean unsorted = true;
		int n = arr.length;
		int temp;

		while( unsorted )
		{
			unsorted = false;
			for( int i = 1; i < n ; i++ )
			{
				count1++;
				if( arr[i] < arr[i-1] )
				{
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
					unsorted = true;
				}
				count1++;
			}
			n--; 
			count1++;
		}
		return arr;
	}
	
	/**
	 * bubbleSort2 uses the bubblesort algorithm to put an 
	 * array in order from least to greatest
	 * @param int[] the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort2( int arr[])
	{
		int temp;
		for( int pass = 1; pass <= arr.length; pass++ )
		{
			for( int i = 1; i <= arr.length - pass; i++ )
			{
				count2++;
				if( arr[i-1] > arr[i] )
				{
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
				count2++;
			}
			count2++;
		}
		return arr;
	}
	
	/**
	 * bubbleSort3 uses the bubblesort algorithm to put an 
	 * array in order from least to greatest
	 * @param int[] the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort3( int arr[])
	{
		int temp;
		for( int pass = 0; pass < arr.length; pass++ )
		{
			for( int i = 0; i < arr.length-1; i++ )
			{
				count3++;
				if( arr[i] > arr[i+1] )
				{
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				count3++;
			}
			count3++;
		}
		return arr;
	}
}


