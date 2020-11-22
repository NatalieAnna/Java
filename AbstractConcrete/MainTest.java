/* EXPLORING CONCRETE & ABSTRACT CLASSES
TEST --> All for the benefit of polymorphism, else you'd need a separate method for each class
with specific parameters (Canine, feline etc).
*/

// superclass
abstract class Animals {

        // public abstract String makeNoise();
}

// subclass
class Canine extends Animals {

	public String makeNoise() {
		return "Woof";
	}
}

// subclass
class Feline extends Animals {

	public String makeNoise() {
		return "Meow";
	}
}

// subclass
class Tiger extends Feline {

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
// When "public abstract String makeNoise();" in class Animals is
// commented out then for loop fails as cannot find symbol a.makeNoise()
       //  symbol:   method makeNoise()
       //  location: variable a of type Animals
class MainTest {
	public static void main(String[] args) {
		Animals[] animals = new Animals[3];
		animals[0] = new Canine();
		animals[1] = new Feline();
		animals[2] = new Tiger();

		for ( int i = 0 ; i < animals.length ; i++ ) {
			System.out.println(Vet.giveShot(animals[i]));
		}
	}
}
