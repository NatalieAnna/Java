import java.util.ArrayList;

// superclass
class Animals {
	public String makeNoise() {
		return "none";
	}
}

// interface is public and abstract
interface Pet {
	void beFriendly();
}

// subclass
class Canine extends Animals {
	@Override // requires same name and param as parent class; must pass Canine IS-A Animal
	public String makeNoise() {
		return "Woof";
	}
}

// subclass
class Dog extends Canine implements Pet {
	public void beFriendly() {
		System.out.println("Is friendly.");
	}
}

class Wolf extends Canine {}

// main method
class Main {
	public static void main(String[] args) {
		// an ArrayList of type Dog with Dog object
		ArrayList<Dog> myDogArrayList = new ArrayList<Dog>();
		Dog aDog = new Dog();
		myDogArrayList.add(aDog);
		Dog doggo = myDogArrayList.get(0);
		System.out.println(doggo); // prints "Dog@3764951d"

		// create Object var to hold first Dog object
		Object o = myDogArrayList.get(0);
		System.out.println(o); // prints "Dog@3764951d"
		// System.out.println(o.makeNoise()); // error cannor find symbol; variable o of type Object
		// cast first Dog object (returned as Object) back to Dog
		Dog d = (Dog) o;
		System.out.println(d.makeNoise()); // print "Woof"

		d.beFriendly(); // prints Is friendly.

		Wolf aWolf = new Wolf();
		//aWolf.beFriendly(); // cannot find method
		//myDogArrayList.add(aWolf); // error: incompatible types: Wolf cannot be converted to Dog
		//Dog wolfDog = (Dog) aWolf; // error: incompatible types: Wolf cannot be converted to Dog

		// create ArrayList of type Object
		ArrayList<Object> myObjectList = new ArrayList<Object>();
		// create Dog object
		Dog anotherDog = new Dog();
		// add Dog object to Object ArrayList
		myObjectList.add(anotherDog);
		// create Wolf object
		Wolf anotherWolf = new Wolf();
		// add Wolf object to Object Arraylist
		myObjectList.add(anotherWolf);
		// print first and second objects in ArrayList
		System.out.println(myObjectList.get(0)); // prints Dog@3cd1a2f1
		System.out.println(myObjectList.get(1)); // prints Wolf@2f0e140b

		// cast Object to Dog
		Dog anoDog = (Dog) myObjectList.get(0);
		// call Canine method on Dog var
		System.out.println(anoDog.makeNoise()); // prints "Woof"
		// call interface method on Dog var
		anoDog.beFriendly(); // prints "Is friendly

		// repeat for wolf. Note that cannot call interface Pet methods as Wolf doesn't implement Pet
		Wolf anoWolf = (Wolf) myObjectList.get(1);
		System.out.println(anoWolf); // prints Wolf@2f0e140b
		System.out.println(anoWolf.makeNoise()); // prints "Woof"
//		anoWolf.beFriendly(); // cannot find method
	}
}
