public class SelectionSort
{
	public static void main(String [] args)
	{
		int [] array = {50,7,4,2,9,14,1};
		printArray(array);
		selSort(array);
		printArray(array);
		checkSorted(array, 0, 6);
	}
	
    public static void selSort(int [] a)
    {   
        int minIndex;

        for (int i = 0; i < a.length-1; ++i)
        {
            minIndex = indexOfSmallestElement(a, i, a.length-1);
            swapElements(a, i, minIndex);
        }
    }
    
    private static int indexOfSmallestElement(int [] a, int first, int last)
	{
    	int currentMinIndex = first;

    	for (int i=first+1 ; i<=last ; ++i)
    	{
    		if ( a[i] < a[currentMinIndex] )
    			currentMinIndex = i;
    	}
    	return currentMinIndex;
    } 

	private static void swapElements(int [] a, int ind1, int ind2)
	{
		int temp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = temp;
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
	
	private static int checkSorted(int [] a, int first, int last)
	{
		for (int i = first+1; i <= last; ++i)
		{
			if ( a[i-1] > a[i] )
			{
				System.out.println("Array is not sorted");
				return -1;
			}
		}
		System.out.println("Array is sorted");
		return 1;
	}
}

/*
Output:

{50,7,4,2,9,14,1}
{1,2,4,7,9,14,50}
Array is sorted

*/
