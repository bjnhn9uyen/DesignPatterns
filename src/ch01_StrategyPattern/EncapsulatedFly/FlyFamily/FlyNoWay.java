package ch01_StrategyPattern.EncapsulatedFly.FlyFamily;

import ch01_StrategyPattern.EncapsulatedFly.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly");
	}

}
