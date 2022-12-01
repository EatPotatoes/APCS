
public class SearchableArray 
{
	private final int SIZE = 10;
	private int[] numbers = new int[SIZE];	
	
	public SearchableArray()
	{
		for(int i = 0; i < SIZE; i++)
			numbers[i] = (int)(Math.random() * 101);
	}
	
	/**
	 * Uses linear search to search for the target
	 * @param target the element to find
	 * @return the index of the target
	 */
	public int linearSearch(int target)
	{
		for (int index = 0; index < numbers.length; index++)
	         if (target == numbers[index])
	            return index;
	      return -1;
	}
	
	/**
	 * Returns the array
	 * @return the array
	 */
	public int[] getArray()
	{
		return numbers;
	}
	
	/**
	 * Returns the size of the array
	 * @return the size of the array
	 */
	public int getSize()
	{
		return SIZE;
	}
	
	public String toString()
	{
		String result = "Array: ";
		
		for(int i = 0; i < SIZE; i++)
			result = result + numbers[i] + " ";
		
		return result;
	}
}
