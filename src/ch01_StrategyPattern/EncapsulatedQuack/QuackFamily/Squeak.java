package ch01_StrategyPattern.EncapsulatedQuack.QuackFamily;

import ch01_StrategyPattern.EncapsulatedQuack.QuackBehavior;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squeak!");
	}

}
