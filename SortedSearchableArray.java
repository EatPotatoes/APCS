
public class SortedSearchableArray extends SearchableArray
{
	private int[] nums = new int[super.getSize()];
	
	public SortedSearchableArray() 
	{
		super();
		nums = super.getArray();
		this.sort(nums);
	}
	
	/**
	 * Sorts the array
	 * @param numbers the array to be sorted
	 */
	public void sort(int[] A)
	{
		int key;      //value that i will compare to
	   	int position; //where i am comparing in my array
	      for (int index = 1; index < A.length; index++)
	      {
	         key = A[index];
	         position = index;
		         // shift larger values to the right
	         while (position > 0 && A[position-1] > key)
	         {
	            A[position] = A[position-1];
	            position--;
	         }
	            
	         A[position] = key;
	      }
	}
	
	/**
	 * Uses binary search to find a target
	 * @param target the target to find
	 * @return the index of the target	
	 */
	public int binarySearch (int target)
	{
		int low = 0, high = nums.length-1, middle = (low + high) / 2;
		while (nums[middle] != target && low <= high)
	    {
		    if (target < nums[middle])
		    	high = middle - 1;
		    else
		     	low = middle + 1;
		    middle = (low + high) / 2;
	    }
	    if (nums[middle] == target)
	    	return middle;
	    else
	    	return -1;
	}
	
	public String toString()
	{
		String result = "Sorted Array: ";
		
		for(int i = 0; i < nums.length; i++)
			result = result + nums[i] + " ";
		
		return result;
	}
}
