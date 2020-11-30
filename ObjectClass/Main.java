/* EXPLORING THE OBJECT CLASS
Every class in Java extends class Object.
*/

// superclass
class Animals {
	String location = "nowhere";
	public boolean attendedSchool = false;

	public Animals () {
	}

	public String makeNoise() {
		return "none";
	}

        public boolean getSchool() {
                return attendedSchool;
        }

	// all calls to this method return the Animals version
	public String getLocation() {
		return location;
	}
}

// subclass
class Canine extends Animals {
	String location = "Bushtrack";
	boolean attendedSchool = true;

	@Override
	public boolean getSchool() {
		return attendedSchool;
	}

	public int canineOnlyMethod(int n) {
		return n;
	}

	@Override // requires same name and param as parent class; must pass Canine IS-A Animal
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
	boolean attendedSchool = false;

	@Override
	public String makeNoise() {
		return "Meow";
	}

        public boolean getSchool() {
                return attendedSchool;
        }

        public String getLocation() {
                return location;
        }
}

class Tiger extends Feline {
	String location = "Jungle";
	boolean attendedSchool = true;

	@Override
	public String makeNoise() {
		return "Roar";
	}

	// must have own getSchool()
        public boolean getSchool() {
                return attendedSchool;
        }

        public String getLocation() {
                return location;
        }
}

// polymorphic arguments & return types
class Vet {
	public static String giveShot(Animals a) {
		return a.makeNoise();
	}

	//Overload (not Override)
	public static String giveShot(Animals a, int quantity) {
		return a.makeNoise() + ", " + quantity;
	}

        //Overload (not Override)
	// each subclass must have own getLocation()
        public static String giveShotWhere(Animals a, int quantity) {
                return a.makeNoise() + ", at " + a.getLocation() + ", " + quantity + " mLs.";
        }

}

// main method
class Main {
	public static void main(String[] args) {
		Animals[] animals = new Animals[3];
		animals[0] = new Canine();
		animals[1] = new Feline();
		animals[2] = new Tiger();

		if ( animals[0].equals(animals[1]) )
			System.out.println("The objects are equal");
		else
			System.out.println("The objects are not equal");

		System.out.println(animals[2].getClass());
		System.out.println(animals[2].hashCode());
		System.out.println(animals[1].toString());

		for ( int i = 0 ; i <= animals.length ; i++ ) {
		}
	}
}

/*
Prints

The objects are not equal
class Tiger
1259475182
Feline@4d7e1886

*/
