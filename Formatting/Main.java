class Main {

	public static void main(String[] args) {
		// take the 2nd argument to this method and format it as a decimal integer and insert commas
		// "format String" = "%,d%"
		// format("%[argument number][flags][width][.precision]type", someArgument)
		// format("%,6.1f", 42.000)
		// format("%                    ,       6        .1      f" , 42.000)
		// only 'type' is mandatory
		String s = String.format("%,d", 1000000);
		System.out.println(s);

		String t = String.format("Another %.2f example", 123.45678);
		System.out.println(t);

		String u = String.format("Another %,.1f example", 99999.99999);
		System.out.println(u);

		int one = 4999;
		double two = 5100.0000;
		String v = String.format("The result is %,d out of %,.2f", one, two);
		System.out.println(v);
	}

}

/*
Prints

1,000,000
Another 123.46 example
Another 100,000.0 example
The result is 4,999 out of 5,100.00

*/
