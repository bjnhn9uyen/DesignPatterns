package ch07_AdapterPattern;

import ch07_AdapterPattern.ExistingSystem.Duck;
import ch07_AdapterPattern.ExistingSystem.MallardDuck;
import ch07_AdapterPattern.VendorClasses.WildTurkey;

public class TurkeyAdapterTestDrive {

	public static void main(String[] args) {

		// create a Duck and a Turkey.
		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();

		// make the turkey look like a Duck by wrapping it in a TurkeyAdapter
		Duck turkeyAdapter = new TurkeyAdapter(turkey);

		// make the Turkey gobble, make it fly
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();

		// test the duck
		System.out.println("\nThe Duck says...");
		testDuck(duck);

		// Now the big test, we try to pass off the turkey as a duck,
		// and the adapter gobbles when quack() is called and flies a few times when fly() is called.
		// The testDuck method never knows it has a turkey disguised as a duck
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}

	// the testDuck method takes a duck and calls its quack() and fly() methods.
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

}
