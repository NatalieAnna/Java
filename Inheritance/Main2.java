// superclass
class Car {
	double speed = 100;
	void accelerate() {
		System.out.println("This vehicle is moving");
	}

	void brake() {
		System.out.println("This vehicle is stopping");
	}
}

// subclass
class Ferrari extends Car {
	@Override
	void accelerate() {
		speed+=100;
	}
}

// subclass
class RegularCar extends Car {
}

// main method
public class Main2 {
	public static void main(String [] args)  {
		Ferrari ferrari = new Ferrari();
		ferrari.accelerate();
		System.out.println(ferrari.speed);
		System.out.println();
		RegularCar regularcar = new RegularCar();
		regularcar.accelerate();
		System.out.println(regularcar.speed);
	}	
}

/**
Output:

200.0

This vehicle is moving
100.0

*/
