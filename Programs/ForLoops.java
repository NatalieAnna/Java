/* For loops. */

public class ForLoops
{   
	private int[] arrA; 

	public static void main(String[] args)
	{
		int[] firstArr = {2,4,6,8};
		ForLoops secondArr = new ForLoops(firstArr);
		System.out.println("Starting array: " + secondArr.toString());
		System.out.println("Sum of array: " + secondArr.sumOfArray());
		System.out.println("Minimum value: " + secondArr.minimumValue());
		secondArr.insertElementAtStart(0);
		System.out.println("After inserted element: " + secondArr.toString());
		secondArr.reverseArray();
		System.out.println("Reversed array: " + secondArr.toString());
	}

	public ForLoops(int[] arrB)
	{
		arrA = new int[arrB.length];

		for(int i = 0; i < arrB.length; i++) 
		{
			arrA[i] = arrB[i];
		}
	} 

	public String toString()
	{
		String str = "{" + arrA[0];

		for (int i =1; i <arrA.length; i++) 
		{
			str = str + ", " + arrA[i];
		}
		str = str + "}";
		return str;
	}

	public int sumOfArray()
	{
		int sum = 0;

		for (int i = 0; i < arrA.length; i++) 
		{
 			sum = sum + arrA[i];
		}
		return sum;
	}

	
	public int minimumValue()
	{
		int minVal = arrA[0];

		for (int i = 1; i < arrA.length; i++) 
		{
			if (minVal > arrA[i])
			{
				minVal = arrA[i];
			}
		}
		return minVal;
	}

	public void insertElementAtStart(int newElement)
	{   
		for (int i = arrA.length-1; i > 0; i--)
		{
			arrA[i] = arrA[i-1];
		}
		arrA[0] = newElement;
	} 

	private void swapTwoElements(int i, int j)
	{
		int temp;

		temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;

	}

	public void reverseArray()
	{

		int i = 0;
		int j = arrA.length-1;

		while ( i < j)
		{
			swapTwoElements(i,j);
			i++;
			j--;
		}
	}
}