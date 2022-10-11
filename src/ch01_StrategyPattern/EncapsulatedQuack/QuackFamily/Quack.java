package ch01_StrategyPattern.EncapsulatedQuack.QuackFamily;

import ch01_StrategyPattern.EncapsulatedQuack.QuackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack!");
	}

}
