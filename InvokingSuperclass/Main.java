// superclass
class Animals {
	public String makeNoise() {
		return "I make noise - ";
	}
}

// subclass
class Canine extends Animals {
	@Override
	public String makeNoise() {
		return super.makeNoise() + " Woof";
	}
}

// subclass
class Dog extends Canine {}

// main method
class Main {
	public static void main(String[] args) {
		Dog aDog = new Dog();
		System.out.println(aDog.makeNoise());
	}
}

/* prints "I make noise -  Woof" */
