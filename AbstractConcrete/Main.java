/* EXPLORING CONCRETE & ABSTRACT CLASSES
Keyword 'abstract' prevents a class from being instantiated.
An abstract method must be overridden. These methods define a subclass protocol.
An abstract method must be in an abstract class.
All for the benefit of polymorphism, else you'd need a separate method for each class
with specific parameters (Canine, feline etc).
The first concrete class in the inheritance tree must implement (provide a body) all abstract methods.
*/

// superclass
abstract class Animals {

/*	public String makeNoise() {
		return "none";
	}
*/

        public abstract String makeNoise();

	// throws error: Canine is not abstract and does not override abstract method sleep() in Animals
	// solved by adding sleep() to class Canine.
	public abstract void sleep();
}

// subclass
class Canine extends Animals {

	@Override // requires same name and param as parent class; must pass Canine IS-A Animal
	public String makeNoise() {
		return "Woof";
	}

	// after this, thows error in class Feline
	// error: Feline is not abstract and does not override abstract method sleep() in Animals
	public void sleep() {};
}

// subclass
class Feline extends Animals {

	@Override
	public String makeNoise() {
		return "Meow";
	}

	// error solved. No additional error for class Tiger as is subclass of Feline.
	public void sleep() {};
}

// sub-subclass (?)
class Tiger extends Feline {

	@Override
	public String makeNoise() {
		return "Roar";
	}
}

// polymorphic arguments & return types
class Vet {
	public static String giveShot(Animals a) {
		return a.makeNoise();
	}
}

// main method
class Main {
	public static void main(String[] args) {
		Animals[] animals = new Animals[3];
		animals[0] = new Canine();
		animals[1] = new Feline();
		animals[2] = new Tiger();
		// animals[3] = new Animals();
		// prints 'none' if class is not abstract (note: array length)
		// thows error if class is abstract

		for ( int i = 0 ; i < animals.length ; i++ ) {
			System.out.println(animals[i].makeNoise());
		}
	}
}
