
public class driver 
{

	public static void main(String[] args) 
	{
		SearchableArray array = new SearchableArray();
		
		System.out.println(array.toString());
		
		SortedSearchableArray a2 = new SortedSearchableArray();
		
		System.out.println(a2.toString());
		
		System.out.println("\nInts in array are random so searching will be done always on index 3\n");
		System.out.println("Linear on sorted array object: " + a2.linearSearch(a2.getArray()[3]));
		System.out.println("Binary on sorted array object: " + a2.binarySearch(a2.getArray()[3]));
		System.out.println("Search for nonexistent element: " + a2.binarySearch(523));

	}

}
