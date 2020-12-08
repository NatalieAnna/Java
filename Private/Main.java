class Animals {}

class Canine extends Animals {
	private Canine() {
		System.out.println("private Canine constructor");
	}
}

// cannot subclass private Canine
// error: Canine() has private access in Canine
  // class Dog extends Canine {)
class Dog extends Animals {
	public Dog() {
		System.out.println("public Dog constructor");
	}
}

class Main {
	public static void main(String [] args) {
		// error: Canine() has private access in Canine
		// Canine canine = new Canine();
		Dog dog = new Dog();
	}
}
/*
Prints:

public Dog constructor

*/
