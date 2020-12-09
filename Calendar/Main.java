import java.util.Calendar;

class Main {

	public static void main(String [] args) {
		// error: Calendar is abstract; cannot be instantiated
		// Calendar cal = new Calendar();

		// calendar fields have been initialised with the current date and time
		Calendar c = Calendar.getInstance();
		System.out.println("It is: " + c.getTime());

		long millis = c.getTimeInMillis();
		System.out.println("Time in milliseconds: " + millis);

		c.add(Calendar.DATE, -3);
		System.out.println("3 days ago: " + c.getTime());

		c.add(Calendar.MONTH, 1);
		System.out.println("1 month later: " + c.getTime());
	}
}

/*
Prints:

It is: Wed Dec 09 13:59:49 AEDT 2020
Time in milliseconds: 1607482789017
3 days ago: Sun Dec 06 13:59:49 AEDT 2020
1 month later: Wed Jan 06 13:59:49 AEDT 2021

*/
