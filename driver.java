// WordLister.java

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads a list of words from a text file and displays them.
 * 
 */
public class driver 
{
	static int counter = 0;
	
	public static void main(String[] args) throws IOException 
	{
		String line;
		String word;
		
		ArrayList<Earthquake> quakes = new ArrayList<Earthquake>();
	
		//Open the text file for reading
		Scanner input = new Scanner(new File("quak2000.txt"));
		
		line = input.nextLine();
		while(input.hasNext())
		{
			line = input.nextLine();
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			
			double[] values = new double[5];
			
			for(int i = 0; i < 5; i++)
			{
				word = sc.next();
				values[i] = Double.parseDouble(word); 
			}
			Earthquake check = new Earthquake(values);
			//if((check.getDate() % 100 > 0 & check.getDate() % 100 < 15) || (check.getDate() % 100 > 24))
			//if(check.getLongitude() >= 0)
			quakes.add(new Earthquake(values));
			
		}
		System.out.println("Size: " + quakes.size());
		Earthquake[] eq = new Earthquake[quakes.size()];
		eq = quakes.toArray(eq);
		
		sortMagnitude(eq);
		double max = 0;
		
		/*
		for(int i = 0; i < eq.length; i++)
		{
			if (eq[i].getDepth() > max)
				max = eq[i].getDepth();
			//System.out.println(eq[i].getDepth());
		}
		System.out.println("Max: " + max);
		*/
		
		
		Earthquake q = binarySearch(eq, 5.5);
		System.out.println(q.toString());
		System.out.println("Counter: " + counter);
		
	}
	
	public static void sortDate(Earthquake[] input)
	{
		int min;
		Earthquake temp;

	      for (int index = 0; index < input.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < input.length; scan++)
	            if (input[scan].getDate() < input[min].getDate())
	            //change < to > for descending order
	               min = scan;

	         // Swap the values
	         temp = input[min];
	         input[min] = input[index];
	         input[index] = temp;
	      }
	}
	
	public static void sortLatitude(Earthquake[] input)
	{
		int min;
		Earthquake temp;

	      for (int index = 0; index < input.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < input.length; scan++)
	            if (input[scan].getLatitude() < input[min].getLatitude())
	               min = scan;

	         // Swap the values
	         temp = input[min];
	         input[min] = input[index];
	         input[index] = temp;
	      }
	}
	
	public static void sortLongitude(Earthquake[] input)
	{
		int min;
		Earthquake temp;

	      for (int index = 0; index < input.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < input.length; scan++)
	            if (input[scan].getLongitude() < input[min].getLongitude())
	               min = scan;

	         // Swap the values
	         temp = input[min];
	         input[min] = input[index];
	         input[index] = temp;
	      }
	}
	
	public static void sortDepth(Earthquake[] input)
	{
		int min;
		Earthquake temp;

	      for (int index = 0; index < input.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < input.length; scan++)
	            if (input[scan].getDepth() < input[min].getDepth())
	               min = scan;

	         // Swap the values
	         temp = input[min];
	         input[min] = input[index];
	         input[index] = temp;
	      }
	}
	
	public static void sortMagnitude(Earthquake[] input)
	{
		int min;
		Earthquake temp;

	      for (int index = 0; index < input.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < input.length; scan++)
	            if (input[scan].getMagnitude() < input[min].getMagnitude())
	               min = scan;

	         // Swap the values
	         temp = input[min];
	         input[min] = input[index];
	         input[index] = temp;
	      }
	}
	
	public static Earthquake linearSearch (Earthquake[] numbers, double target)
	{
	    counter = 0;
		for (int index = 0; index < numbers.length; index++)
		{
	    	counter++;
			if (target == numbers[index].getDate())
	    	//if (target == numbers[index].getLatitude())
	    	//if (target == numbers[index].getLongitude())
	        //if (target == numbers[index].getDepth())
			//if (target == numbers[index].getMagnitude())
			{
	    		System.out.println("Index: " + index);
				return numbers[index];
			}
		}
		double[] notFound = new double[] {-1, -1, -1, -1};
		return new Earthquake(notFound);
	}
	
	public static Earthquake binarySearch (Earthquake[] numbers, double target)
	{
		int low = 0, high = numbers.length-1, middle = (low + high) / 2;
		counter = 0;
	    //while (numbers[middle].getDate() != target && low <= high)
	    //while (numbers[middle].getLatitude() != target && low <= high)
	    //while (numbers[middle].getLongitude() != target && low <= high)
	    //while (numbers[middle].getDepth() != target && low <= high)
	    while (numbers[middle].getMagnitude() != target && low <= high)
	    {
	    	counter++;
	        //if (target < numbers[middle].getDate())
	        //if (target < numbers[middle].getLatitude())
	    	//if (target < numbers[middle].getLongitude())
	    	//if (target < numbers[middle].getDepth())
	    	if (target < numbers[middle].getMagnitude())
	        	high = middle - 1;
	        else
	    	   low = middle + 1;
	        middle = (low + high) / 2;
	    }
	    
	    double[] notFound = new double[] {-1, -1, -1, -1, -1};
	    
	    counter++;
	    //if (numbers[middle].getDate() == target)
	    //if (numbers[middle].getLatitude() == target)
	    //if (numbers[middle].getLongitude() == target)
	    //if (numbers[middle].getDepth() == target)
	    if (numbers[middle].getMagnitude() == target)
	    {
	       System.out.println("Index: " + middle);
	       return numbers[middle];
	    }
	    else
			return new Earthquake(notFound);
	}
}