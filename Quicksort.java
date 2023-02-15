
public class Quicksort 
{
	public static int quickCount = 0;
	public static int insertCount = 0;
	public static int quickInsertCount = 0;
	public static int pivotCount = 0;
	
	public static void main(String[] args) 
	{
		int[] a1 = new int[50000];
		int[] a2 = new int[50000];
		
		for(int i = 0; i < 50000; i++)
		{
			int rand = (int) (Math.random() * 100000);
			a1[i] = rand;
			a2[i] = rand;
		}
		
		quickSort(a1);
		insertionSort(a2);
		
		System.out.println("QuickSort 1: " + quickCount);
		System.out.println("InsertionSort 1: " + insertCount);
		
		quickCount = 0;
		insertCount = 0;
		
		int[] b1 = new int[500];
		int[] b2 = new int[500];
		
		for(int i = 0; i < 500; i++)
		{
			int rand2 = (int) (Math.random() * 100000);
			b1[i] = rand2;
			b2[i] = rand2;
		}
		
		quickSort(b1);
		insertionSort(b2);
		System.out.println("QuickSort 2: " + quickCount);
		System.out.println("InsertionSort 2: " + insertCount);
		
		quickCount = 0;
		insertCount = 0;
		
		int[] c1 = new int[50000];
		int[] c2 = new int[50000];
		int[] c3 = new int[50000];
		
		for(int i = 0; i < 50000; i++)
		{
			int rand3 = (int) (Math.random() * 100000);
			c1[i] = rand3;
			c2[i] = rand3;
			c3[i] = rand3;
		}
		
		quickSort(c1);
		insertionSort(c2);
		quickInsertionSort(c3);
		System.out.println("QuickSort 3: " + quickCount);
		System.out.println("InsertionSort 3: " + insertCount);
		System.out.println("QuickInsertionSort: " + quickInsertCount);
	}
	public static void quickSort (int[] numbers)
	{
		doQuickSort(numbers, 0, numbers.length - 1);
	}
	//-----------------------------------------------------------------
	//  Recursively sorts the portion of the given array beginning
	//  at start and ending at end.
	//-----------------------------------------------------------------
	private static void doQuickSort (int[] numbers, int start, int end)
	{
		quickCount++;
		if (start < end)
	    {
			int middle = partition(numbers, start, end);
	        doQuickSort(numbers, start, middle);
	        doQuickSort(numbers, middle + 1, end);
	    }
	}
	   //-----------------------------------------------------------------
	   //  Partitions the array such that each value in [start, middle]
	   //  is less than or equal to each value in [middle + 1, end].
	   //  The index middle is determined in the procedure and returned.
	   //-----------------------------------------------------------------
	private static int partition (int[] numbers, int start, int end)
	{
		int pivot = numbers[start];
	    int i = start - 1;
	    int j = end + 1;
	      // As the loop progresses, the indices i and j move towards each other.
	      // Elements at i and j that are on the wrong side of the partition are
	      // exchanged. When i and j pass each other, the loop ends and j is
	      // returned as the index at which the elements are partitioned around.
	    while (true)
	    {
	    	quickCount++;
	    	i = i + 1;
	        quickCount++;
	    	while (numbers[i] < pivot)
	    	{
	        	i = i + 1;
	        	quickCount++;
	    	}	

	        j = j - 1;
	        quickCount++;
	        while (numbers[j] > pivot)
	        {
	        	j = j - 1;
	        	quickCount++;
	        }

	        quickCount++;
	        if (i < j)
	        {
	            int tmp = numbers[i];
	            numbers[i] = numbers[j];
	            numbers[j] = tmp;
	        }
	        else return j;
	    }
	}
	
	public static void insertionSort (int[] numbers)
	{
		int key;      //value that i will compare to
	   	int position; //where i am comparing in my array
	   
	    for (int index = 1; index < numbers.length; index++)
	    {
	    	//insertCount++;
	    	key = numbers[index];
	        position = index;

	         // shift larger values to the right
	        while (position > 0 && numbers[position-1] > key)
	        {
	        	insertCount++;
	        	numbers[position] = numbers[position-1];
	            position--;
	        }
	            
	        numbers[position] = key;
	     }
	}
	
	public static void quickInsertionSort (int[] numbers)
	{
		doQuickInsertionSort(numbers, 0, numbers.length - 1);
	}
	
	private static void doQuickInsertionSort (int[] numbers, int start, int end)
	{
		quickInsertCount++;
		if (start < end)
		{
			int middle = partition2(numbers, start, end);
			pivotCount++;
			if(pivotCount < 49850)
		    {
				doQuickInsertionSort(numbers, start, middle);
				doQuickInsertionSort(numbers, middle + 1, end);
		    }
			else
				insertionSort2(numbers);
		}
		
	}
	
	private static int partition2 (int[] numbers, int start, int end)
	{
		int pivot = numbers[start];
	    int i = start - 1;
	    int j = end + 1;
	      // As the loop progresses, the indices i and j move towards each other.
	      // Elements at i and j that are on the wrong side of the partition are
	      // exchanged. When i and j pass each other, the loop ends and j is
	      // returned as the index at which the elements are partitioned around.
	    while (true)
	    {
	    	i = i + 1;
	        quickInsertCount++;
	    	while (numbers[i] < pivot)
	    	{
	        	i = i + 1;
	        	quickInsertCount++;
	    	}	

	        j = j - 1;
	        quickInsertCount++;
	        while (numbers[j] > pivot)
	        {
	        	j = j - 1;
	        	quickInsertCount++;
	        }

	        quickInsertCount++;
	        if (i < j)
	        {
	            int tmp = numbers[i];
	            numbers[i] = numbers[j];
	            numbers[j] = tmp;
	        }
	        else return j;
	    }
	}
	
	public static void insertionSort2 (int[] numbers)
	{
		int key;      //value that i will compare to
	   	int position; //where i am comparing in my array
	   
	    for (int index = 1; index < numbers.length; index++)
	    {
	    	//quickInsertCount++;
	    	key = numbers[index];
	        position = index;

	        //shift larger values to the right
	        while (position > 0 && numbers[position-1] > key)
	        {
	        	quickInsertCount++;
	        	numbers[position] = numbers[position-1];
	            position--;
	        }
	            
	        numbers[position] = key;
	     }
	}
}

//1. QuickInsertionSort is faster because it quicksorts faster for the larger part of the list, 
// and faster for the smaller part of the list with insertion sort.
//2. The insertion sort is significantly closer for the smaller array, implying quicksort works best
// for bigger arrays and insertion works pretty well for small arrays.
//3. The efficiency does seem to change depending on when the breakpoint for changing from
// quicksort to insertion is. I tested a bit and found 150 as the point where it fluctuates from
// being faster or slower depending on the array, so 150 is probably around the point where it is the same.