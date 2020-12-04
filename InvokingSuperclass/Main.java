class Animals {
	public String makeNoise() {
		return "I make noise - ";
	}
}

class Canine extends Animals {
	@Override
	public String makeNoise() {
		return super.makeNoise() + " Woof";
	}
}

class Main {
	public static void main(String[] args) {
		Canine canine = new Canine();
		System.out.println(canine.makeNoise());
	}
}

/*
Prints

"I make noise -  Woof"

*/
