class Animals {
	String location = "nowhere";

	public String makeNoise() {
		return "none";
	}

	public String getLocation() {
		return location;
	}
}


class Canine extends Animals {
	String location = "Bushtrack";

	@Override
	public String makeNoise() {
		return "Woof";
	}

	// if commented out then inherits superclass "nowhere"
	// public String getLocation() {
	// 	return location;
	// }
}


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

	public String getLocation() {
		return location;
	}
}

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

		for ( int i = 0 ; i < animals.length ; i++ ) {
			System.out.println(animals[i] + " is at " + animals[i].getLocation());
		}
	}
}

/*
Prints

The objects are not equal
class Tiger
1259475182
Feline@4d7e1886
Canine@452b3a41 is at nowhere
Feline@4d7e1886 is at Backyard
Tiger@4b1210ee is at Jungle

*/
