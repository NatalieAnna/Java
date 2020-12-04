import java.util.ArrayList;

class Animals {
	public String makeNoise() {
		return "none";
	}
}

class Canine extends Animals {
	@Override
	public String makeNoise() {
		return "Woof";
	}
}

class Dog extends Canine { }


class Main {
	public static void main(String[] args) {
		// ArrayList of type Dog with a Dog object
		ArrayList<Dog> myDogArrayList = new ArrayList<Dog>();
		Dog aDog = new Dog();
		myDogArrayList.add(aDog);
		Dog doggo = myDogArrayList.get(0);
		System.out.println(doggo); // prints "Dog@3764951d"

		// Object var to hold first Dog object
		Object o = myDogArrayList.get(0);
		System.out.println(o); // prints "Dog@3764951d"
		// System.out.println(o.makeNoise()); // error cannor find symbol; variable o of type Object
		// cast first Dog object (returned as Object) back to Dog
		Dog d = (Dog) o;
		System.out.println(d.makeNoise()); // prints "Woof"
	}
}
