package ch01_StrategyPattern;

import ch01_StrategyPattern.EncapsulatedFly.FlyFamily.FlyWithWings;
import ch01_StrategyPattern.EncapsulatedQuack.QuackFamily.Quack;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		// inherit these instance variables from Duck class and assign to the concrete implementation objects
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();

		// we can call these methods any time we want to change the behavior of a duck on the fly (at runtime)
		// by using inherited setter methods in the Duck class
//		setFlyBehavior(new FlyWithWings());
//		setQuackBehavior(new Quack());
	}

	@Override
	void display() {
		System.out.println("I'm a real Red Headed duck");
	}

}
