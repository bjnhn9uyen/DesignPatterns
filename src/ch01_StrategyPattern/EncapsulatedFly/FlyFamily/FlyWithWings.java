package ch01_StrategyPattern.EncapsulatedFly.FlyFamily;

import ch01_StrategyPattern.EncapsulatedFly.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying!!");
	}

}
