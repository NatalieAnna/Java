/* EXPLORING POLYMORPHISM, OBJECT CLASS & CASTING */

import java.util.ArrayList;

// superclass
class Animals {
	public String makeNoise() {
		return "none";
	}
}

// subclass
class Canine extends Animals {
	@Override // requires same name and param as parent class; must pass Canine IS-A Animal
	public String makeNoise() {
		return "Woof";
	}
}

// subclass
class Dog extends Canine { }

// main method
class Main {
	public static void main(String[] args) {
		// an ArrayList of type Dog with Dog object
		ArrayList<Dog> myDogArrayList = new ArrayList<Dog>();
		Dog aDog = new Dog();
		myDogArrayList.add(aDog);
		Dog doggo = myDogArrayList.get(0);
		System.out.println(doggo); // prints "Dog@3764951d"

/*		// an ArrayList of type Object with Dog object
                ArrayList<Object> myDogArrayList2 = new ArrayList<Object>();
                Dog aDog2 = new Dog(); // new Dog object
                myDogArrayList2.add(aDog2); // add to ArrayList of type Object
		Dog d2 = myDogArrayList2.get(0); // error: incompatible types: Object cannot be converted to Dog
                System.out.println(d2);
*/
		// create Object var to hold first Dog object
		Object o = myDogArrayList.get(0);
		System.out.println(o); // prints "Dog@3764951d"
		// System.out.println(o.makeNoise()); // error cannor find symbol; variable o of type Object
		// cast first Dog object (returned as Object) back to Dog
		Dog d = (Dog) o;
		System.out.println(d.makeNoise()); // print "Woof"
	}
}
