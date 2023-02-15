//********************************************************************
//  RecursiveSorts.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the merge sort and quick sort algorithms.
//********************************************************************

public class StringMergeSort
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of integers using merge sort.
   //-----------------------------------------------------------------
   public static void mergeSort (String[] numbers)
   {
      doMergeSort(numbers, 0, numbers.length - 1);
   }

   //-----------------------------------------------------------------
   //  Recursively sorts the the portion of the given array beginning
   //  at start and ending at end.
   //-----------------------------------------------------------------
   private static void doMergeSort (String[] numbers, int start, int end)
   {
      if (start < end)
      {
         int middle = (start + end) / 2;
         doMergeSort (numbers, start, middle);
         doMergeSort (numbers, middle + 1, end);
         merge (numbers, start, middle, end);
      }
   }

   //-----------------------------------------------------------------
   //  Merges in sorted order the two sorted subarrays
   //  [start, middle] and [middle + 1, end].
   //-----------------------------------------------------------------
   private static void merge (String[] numbers, int start, int middle,
                     int end)
   {
      // This temporary array will be used to build the merged list.
      String[] tmp = new String[end - start + 1];

      int index1 = start;
      int index2 = middle + 1;
      int indexTmp = 0;

      // Loop until one of the sublists is exhausted, adding the smaller
      // of the first elements of each sublist to the merged list.
      while (index1 <= middle && index2 <= end)
      {
         if (numbers[index1].length() <= numbers[index2].length())
         {
	         if(numbers[index1].length() == numbers[index2].length())
	         {
        	 	if(numbers[index1].compareTo(numbers[index2]) < 0)
	             {
	            	 tmp[indexTmp] = numbers[index1];
	            	 index1++;
	             }
        	 	else
        	 	{
        	 		tmp[indexTmp] = numbers[index2];
        	 		index2++;
        	 	}
	         }
	         else
             {
        	 tmp[indexTmp] = numbers[index1];
             index1++;
             }
         }
         else
         {
             tmp[indexTmp] = numbers[index2];
             index2++;
         }
          indexTmp++;
      }

      // Add to the merged list the remaining elements of whichever sublist
      // is not yet exhausted.
      while (index1 <= middle)
      {
         tmp[indexTmp] = numbers[index1];
         index1++;
         indexTmp++;
      }
      while (index2 <= end)
      {
         tmp[indexTmp] = numbers[index2];
         index2++;
         indexTmp++;
      }

      // Copy the merged list from tmp into numbers.
      for (indexTmp = 0; indexTmp < tmp.length; indexTmp++)
      {
         numbers[start + indexTmp] = tmp[indexTmp];
      }
   }
   
   public static void main(String[] args)
   {
	   String[] s = {"one", "two", "three", "four", "five"};
	   mergeSort(s);
	   for(int i = 0; i < 5; i++)
		   System.out.println(s[i]);
   }
}
