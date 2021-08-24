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
			insertLast(arr[i]);
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


    /**
     * Inserts an element in the first position. The elements already in the
     * list are pushed up one place.
     * 
     * @param  newElement   the element to be inserted
     */
    public void insertFirst(int newElement)
    {  
        Node temp = new Node(element);
        temp.next = next;
        next = temp;
        element = newElement;

    } // method insertFirst

    /**
     * Inserts an element in the last position. The pre-existing elements in the
     * list are unaffected.
     * 
     * @param  newElement   the element to be inserted
     */
    public void insertLast(int newElement)
    { 
        // add and/or modify code to complete the method

        if ( next == null )
            next = new Node(newElement);
        else
            next.insertLast(newElement);

    } // method insertLast

    /**
     * No change if there is only one element in the list. Otherwise, it moves up one place all
     * elements in the list, by overwriting each "element" with "next.element", thus
     * removing the first value in the list. The last node in the list is removed.
     */
    public void shuffleUp()
    {
        System.out.println("This method is NOT part of the lab test");

    } // method shuffleUp

    /*
     * @return     the number of deletions made (i.e. 0 or 1)
     * 
     * @param  element       the element to be deleted
     * @param  predecessor   a reference to the previous node in the linked list
     *                       i.e. the node where "next" points to this node
     */
    private int delete2(int element, Node predecessor)
    {  
        System.out.println("This method is NOT part of the lab test");
        return 99; // delete this line if completing this method

    } // method delete2

    /**
     * @return     the number of deletions made (i.e. 0 or 1)
     * 
     * @param  element   the element to be deleted
     */
    public int delete(int element)
    {  
        if ( (element == element) && (next == null) )
        {
            System.out.println("Error when attempting to delete '" + element + "'. The list must contain at least one element");
            return 0;
        }

        if ( element == element )
        {
            // if element == element is true then the first "if" statement implies that next != null
            element = next.element;
            next = next.next;
            return 1;
        }

        if ( next == null )
        {
            // if next == null is true then the first "if" statement implies that element != element
            return 0;
        }

        return next.delete2(element, this);

    } // method delete

} // class Node