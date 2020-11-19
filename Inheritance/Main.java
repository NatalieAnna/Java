/* EXPLORING INHERITANCE
Use inheritance to avoid duplicating code in subclasses.
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
}

// subclass
class Feline extends Animals {
	String location = "Backyard";
	boolean attendedSchool = false;

//	@Override
	public String makeNoise() {
		return "Meow";
	}

        public boolean getSchool() {
                return attendedSchool;
        }
}

class Tiger extends Feline {
	String location = "Jungle";
	boolean attendedSchool = true;

	@Override // works without this keyword
	public String makeNoise() {
		return "Roar";
	}

	// must have own getSchool()
        public boolean getSchool() {
                return attendedSchool;
        }
}

// main method
class Main {
	public static void main(String[] args) {
		Animals aa = new Animals();
		System.out.println(aa.makeNoise()); // object = Animals so returns Animals var
		System.out.println(aa.location);
		System.out.println(aa.getSchool()); // returns Animals var
		System.out.println();

		Canine cc = new Canine();
		System.out.println(cc.makeNoise()); // object = Canine so returns Canine var
		System.out.println(cc.location); // Australia
		System.out.println(cc.canineOnlyMethod(100)); // method can only be called on Canine object
		System.out.println(cc.getSchool()); // returns subclass value
		System.out.println();

		Animals ac = new Canine(); // requires constructor in class Animals
		System.out.println(ac.makeNoise()); // object = Canine so returns Canine var
		System.out.println(ac.location); // returns Animals var
		System.out.println(ac.getSchool()); // returns Canine var
		System.out.println();

		Animals af = new Feline(); // Error: Feline cannot be converted to Animals UNLESS "Feline extends Animal"
		System.out.println(af.makeNoise());
		System.out.println(af.location); // returns Animals var
		System.out.println(af.getSchool()); // returns Animals var
		System.out.println();

		Feline ff = new Feline();
		System.out.println(ff.makeNoise()); // returns Feline var
		System.out.println(ff.location); // returns Feline var
		System.out.println(ff.getSchool()); // returns Animals var
		System.out.println();

                Tiger tt = new Tiger();
                System.out.println(tt.makeNoise()); // returns Tiger var
                System.out.println(tt.location); // returns Tiger var
                System.out.println(tt.getSchool()); // returns Animals var
		System.out.println();

                Animals at = new Tiger();
                System.out.println(at.makeNoise()); // returns Tiger var
                System.out.println(at.location); // returns Animals var
                System.out.println(at.getSchool()); // returns Animals var
	}
}

/*
Prints:

none
nowhere
false

Woof
Bushtrack
100
true

Woof
nowhere
true

Meow
nowhere
false

Meow
Backyard
false

Roar
Jungle
true

Roar
nowhere
true

*/
