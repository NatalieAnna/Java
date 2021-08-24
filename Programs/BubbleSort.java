public class BubbleSort
{
	public static void main(String [] args)
	{  
		int [] array = {8,5,0,9,3,1};
		printArray(array);
		BubSort(array);
		printArray(array);
		checkSorted(array, 0, 5);
	}
	
	public static void BubSort(int [] a) 
	{
		for (int right = a.length-1; right >= 0; --right)
		{
			for (int i = 0; i <= right-1; ++i)
			{
				swapToAscending(a, i, i+1);  
			}
		}
	}
    
	private static void swapToAscending(int [] b, int i, int j)
	{
		if ( b[i] > b[j] )
		{
			swap(b, i, j);
		}
	} 
    
	private static void swap(int [] b, int i, int j)
	{
		int temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}
	 
	private static int checkSorted(int [] a, int first, int last)
	{
		for (int i = first+1; i <= last; ++i)
		{
    		if (a[i-1] > a[i])
    		{
    			System.out.println("Array is not sorted");
    			return -1;
    		}
		}
		System.out.println("Array is sorted");
		return 1;
	} 
    
	private static void printArray(int [] a)
	{
		System.out.print("{" + a[0]);

		for (int i = 1; i < a.length; ++i)
		{
			System.out.print("," + a[i]);
		}
		System.out.print("}");
		System.out.println();
	}
}