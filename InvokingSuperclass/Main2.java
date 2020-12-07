abstract class Animals {
	private String name;

	public String getName() {
		return name;
	}

	public Animals(String aName) {
		name = aName;
	}
}

class Canine extends Animals {
	public Canine(String name) {
		super(name);
	}
}

class Main2 {
	public static void main(String[] args) {
		Canine canine = new Canine("Oli");
		System.out.println(canine.getName());
	}
}

/*
Prints

Oli

*/
