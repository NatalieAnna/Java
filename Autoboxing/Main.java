import java.util.ArrayList;

class Main {
	static void takeInteger(Integer i) {
		System.out.println("takeInteger: " + i);
	}

	static void takeInt(int i) {
		System.out.println("takeInt: " + i);
	}

	static int getInt(int x) {
		return x;
	}

	static int getInteger(Integer x) {
		return x;
	}

	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(8);
		list.add(9);

		for ( int val : list ) {
			System.out.println("Value: " + val);
			takeInteger(val);
			takeInt(val);
			System.out.println("getInt: " + getInt(val));
			System.out.println("getInteger: " + getInteger(val));
		}

		if (list.get(0) instanceof Integer) System.out.println("True");
		else System.out.println("False");

		// error: required: class or array
		//if (list.get(0) instanceof int) System.out.println("True");
		//else System.out.println("False");

		// error: Integer cannot be converted to String
		//if (list.get(0) instanceof String) System.out.println("True");
		//else System.out.println("False");

		String s = "4";
		System.out.println("x" + "x");
		// cannot find symbol x
		// System.out.println(x + x);

		// converts String to primitive value
		int x = Integer.parseInt(s);
		System.out.println(x + x);
	}
}

/*
Prints:

Value: 7
takeInteger: 7
takeInt: 7
getInt: 7
getInteger: 7
Value: 8
takeInteger: 8
takeInt: 8
getInt: 8
getInteger: 8
Value: 9
takeInteger: 9
takeInt: 9
getInt: 9
getInteger: 9
True
xx
8

*/
