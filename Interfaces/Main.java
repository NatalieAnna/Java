import java.util.ArrayList;

class Animals {
	public String makeNoise() {
		return "none";
	}
}

// interface is public and abstract
interface Pet {
	String beFriendly();
}

class Canine extends Animals {
	@Override
	public String makeNoise() {
		return "Woof";
	}
}
// implements own abstract method beFriendly()
class Dog extends Canine implements Pet {
	public String beFriendly() {
		return " is friendly.";
	}
}

// does not implement OR INHERIT abstract method beFriendly()
class Wolf extends Canine {}

// implements own abstract method beFriendly()
class Cat extends Animals implements Pet {
	public String beFriendly() {
		return " is not friendly.";
	}
}

class Main {
	public static void main(String[] args) {
		Dog dog = new Dog();
		System.out.println(dog + dog.beFriendly());
		// Wolf wolf = new Wolf();
		// System.out.println(wolf + wolf.beFriendly()); // cannot find method
		Cat cat = new Cat();
		System.out.println(cat + cat.beFriendly());
	}
}

/*
Prints:

Dog@a09ee92 is friendly.
Cat@452b3a41 is not friendly.

*/
