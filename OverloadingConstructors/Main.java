class Animals {
	public Animals() {
		System.out.println("The coat colour is white"); // (5), (9)
	}

	public Animals(String c) {
		System.out.println("The coat colour in Animals is " + c);  // (2)
	}
}

class Canine extends Animals {

	public Canine() {
		// calls super() // 5, (9)
		System.out.println("The coat colour is black"); // 6, 10
	}

	public Canine(String c) {
		super(c);  // 2
		System.out.println("The coat colour in Canine is " + c);  // 3
	}

	public Canine(String c, String s) {
		this(); // 9
		System.out.println("The coat colour is " + c + " and size is " + s);
	}
}

class Main {
	public static void main(String[] args) {
		Canine canine = new Canine("red");  // 1
		Canine canine2 = new Canine();  // 4
		System.out.println(); // 7
		Canine canine3 = new Canine("grey", "medium"); // 8, 11-end
	}
}

/*
Prints

The coat colour in Animals is red
The coat colour in Canine is red
The coat colour is white
The coat colour is black

The coat colour is white
The coat colour is black
The coat colour is grey and size is medium

*/
