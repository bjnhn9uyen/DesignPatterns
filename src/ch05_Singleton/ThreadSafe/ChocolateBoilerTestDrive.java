package ch05_Singleton.ThreadSafe;

public class ChocolateBoilerTestDrive {

	public static void main(String[] args) {
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		boiler.fill();
		boiler.boil();
		boiler.drain();

		ChocolateBoiler boiler2 = ChocolateBoiler.getInstance(); // will return the existing instance

		// use the == operator to see if two reference variables refer to the SAME object on the heap
		System.out.println(boiler == boiler2); // return true
	}

}
