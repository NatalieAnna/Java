class Animals {}

class Ball {}

class Canine extends Animals {}

class Dog extends Canine {
	void catchBall() {
		Ball ball1 = new Ball();
		System.out.println(ball1);
	}
}

class Main {
	public static void main(String [] args) {

		Dog dog1 = new Dog();
		System.out.println(dog1);
		// object to GC #1: reference goes out of scope
		// ball object only exists while method is running
		dog1.catchBall();

		// object to GC #2: set reference to null
		dog1 = null;
		System.out.println(dog1);

		Dog dog2 = new Dog();
		System.out.println(dog2);
		// object to GC #3: assign reference to another object
		dog2 = new Dog();
		System.out.println(dog2);
	}
}

/*
Prints

Dog@3764951d
Ball@4d7e1886
null
Dog@3cd1a2f1
Dog@2f0e140b

*/
