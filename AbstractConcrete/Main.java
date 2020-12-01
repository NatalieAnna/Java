// superclass
abstract class Animals {
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

// subclass
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
