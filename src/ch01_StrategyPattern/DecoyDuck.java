package ch01_StrategyPattern;

import ch01_StrategyPattern.EncapsulatedFly.FlyFamily.FlyNoWay;
import ch01_StrategyPattern.EncapsulatedQuack.QuackFamily.MuteQuack;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		// inherit these instance variables from Duck class and assign to the concrete implementation objects
//		flyBehavior = new FlyNoWay();
//		quackBehavior = new MuteQuack();

		// we can call these methods any time we want to change the behavior of a duck on the fly (at runtime)
		// by using inherited setter methods in the Duck class
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	@Override
	void display() {
		System.out.println("I'm a duck Decoy");
	}

}
