abstract class Animals {

	public abstract String makeNoise();
	public abstract String sleep();
}

class Canine extends Animals {

	// must override abstract makeNoise() in superclass
	@Override
	public String makeNoise() {
		return "Woof";
	}

	public String sleep() {
		return "zzz";
	};
}

class Feline extends Animals {

	// must override abstract makeNoise() in superclass
	@Override
	public String makeNoise() {
		return "Meow";
	}

	public String sleep() {
		return "purr";
	};
}

class Tiger extends Feline {

	// does not need to override makeNoise() in superclass. Returns "meow".
	// @Override
	// public String makeNoise() {
	// 	return "Roar";
	// }

	public String sleep() {
		return "rarr";
	};
}

// polymorphic arguments & return types
class Vet {
	public static String giveShot(Animals a) {
		return a.makeNoise() + " after shot, then " + a.sleep();
	}
}

class Main {
	public static void main(String[] args) {
		Animals[] animals = new Animals[3];
		animals[0] = new Canine();
		animals[1] = new Feline();
		animals[2] = new Tiger();

		// error: ArrayIndexOutOfBoundsException
		// animals[3] = new Tiger();

		// error: Animals is abstract; cannot be instantiated
		// animals[3] = new Animals();

		for ( int i = 0 ; i < animals.length ; i++ ) {
			System.out.println(Vet.giveShot(animals[i]));
		}
	}
}

/*
Prints:

Woof after shot, then zzz
Meow after shot, then purr
Meow after shot, then rarr

*/
