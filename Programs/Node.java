/* Nodes/linked lists and recursion.
 * The size of the list is variable after the object is created and
 * the code assumes there is at least one element in the list.
 */

public class Node
{   
	private int element;
	private Node next; 
	private final int nodeID;
	private static int nodeCount = 0; 

	public static void main(String[] args)
	{
		int[] array = {2,4,6,8};
		Node linkedlist = new Node(array);
		System.out.println("Nodes: " + nodeCount);
		System.out.println("First node's element: " + linkedlist.getFirstElement());
		System.out.println(linkedlist.toString());
		System.out.println("Sum of elements: " + linkedlist.sumOfElements());
		System.out.println("Replacements made: " + linkedlist.replaceElement(6, 1));
		System.out.println(linkedlist.toString());
		System.out.println("Smallest element: " + linkedlist.smallestElement());
		System.out.print("Insert node at start: ");
		linkedlist.insertStart(111);
		System.out.println(linkedlist.toString());
		System.out.print("Insert node at end: ");
		linkedlist.insertEnd(999);
		System.out.println(linkedlist.toString());
		System.out.print("Delete node with element = 4: ");
		linkedlist.delete(4);
		System.out.println(linkedlist.toString());
	}

	public Node(int value)	// always the head node
	{
		element = value;
		next = null;
		++nodeCount;
		nodeID = nodeCount;
	}

	public Node(int [] arr)
	{
		this(arr[0]);	// calls the other constructor

		for (int i=1 ; i<arr.length ; ++i)
		{
			insertEnd(arr[i]);
		}
	}

	public int getFirstElement()
	{
		return element;
	}

	public String toStringNode()
	{
		return "[#" + nodeID + ", " + element + "]->";
	}

	private String toStringAll()
	{
		String str = toStringNode();

		if ( next != null )	
		{
			str = str + next.toStringAll();
		}
		else	
		{
			str = str + "null";
		}
		return str;
	} 

	public String toString()
	{
		String str = toStringNode();

		if ( next != null )
		{
			str = str + next.toStringAll();
		}
		return str;

	}

	public int sumOfElements()
	{
		if ( next == null )
		{
			return element;
		} 
		else
		{
			return element + next.sumOfElements();
		}
	}

	public int replaceElement(int a, int b)
	{
		int count = 0; 

		if ( next != null )
		{
			count = next.replaceElement(a, b);
		}
		
		if ( element == a)
		{
			element = b;
			return 1 + count;
		}
		else
		{
			return count;
		}
	}

	public int smallestElement()
	{
		int min;

		if (next == null)
		{
			return element;
		}

		min = next.smallestElement();

		if (element <= min)
		{
			return element; 
		} 
		else
		{
			return min;
		}
	}


	public void insertStart(int newElement)
	{  
		Node temp = new Node(element);
		temp.next = next;
		next = temp;
		element = newElement;
	}

	public void insertEnd(int newElement)
	{ 
		if ( next == null )
		{
			next = new Node(newElement);
		}
		else
		{
			next.insertEnd(newElement);
		}
	}
 
	public int delete(int value)
	{
		if ( (element == value) && (next == null) )
		{
			System.out.println("Error: The list must contain at least one element.");
			return 0;
		}

		if ( element == value )
		{
			element = next.element;
			next = next.next;
			return 1;
		}

		if ( next == null )
		{
			return 0;
		}

		return next.delete(value);
	}
}