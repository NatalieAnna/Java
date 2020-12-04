// superclass
class Animals {
	String location = "nowhere";

	public String makeNoise() {
		return "none";
	}

	public String getLocation() {
		return location;
	}
}

// subclass
class Canine extends Animals {
	String location = "Bushtrack";

	// if commented out would return "none" as per superclass
	@Override
	public String makeNoise() {
		return "Woof";
	}

	public String getLocation() {
		return location;
	}
}

// subclass
class Feline extends Animals {
	String location = "Backyard";

	@Override
	public String makeNoise() {
		return "Meow";
	}

    public String getLocation() {
        return location;
    }
}

class Tiger extends Feline {
	String location = "Jungle";

	@Override
	public String makeNoise() {
		return "Roar";
	}

	// Tiger's location will be inherited from Feline (i.e., = backyard)
	// (as method commented out)
	// public String getLocation() {
	// 	return location;
	// }
}
	// overloaded method (not override)
	// polymorphic arguments & return types
	// each subclass must have its own makeNoise() and getLocation()
class Vet {
	public static String giveShot(Animals a, int quantity) {
		return a + " says " + a.makeNoise() + " while at " + a.getLocation() + " after " + quantity + " mL shot.";
	}
}

// main method
class Main {
	public static void main(String[] args) {
		// polymorphism - the reference type is the superclass of the object type
		Animals[] animals = new Animals[3];
		animals[0] = new Canine();
		animals[1] = new Feline();
		animals[2] = new Tiger();

		// passes in all subclass objects at runtime
		for ( int i = 0 ; i < animals.length ; i++ ) {
			System.out.println(animals[i].makeNoise());
			System.out.println(animals[i].getLocation());
			System.out.println(Vet.giveShot(animals[i], 3));
			System.out.println();
		}
	}
}

/*
Prints

Woof
Bushtrack
Canine@816f27d says Woof while at Bushtrack after 3 mL shot.

Meow
Backyard
Feline@87aac27 says Meow while at Backyard after 3 mL shot.

Roar
Backyard
Tiger@3e3abc88 says Roar while at Backyard after 3 mL shot.


*/
