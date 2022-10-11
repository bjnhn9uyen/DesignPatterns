package ch03_DecoratorPattern.Component.ConcreteComponents;

import ch03_DecoratorPattern.Component.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		// the description instance variable is inherited from Beverage
		description = "Dark Roast";
	}

	@Override
	public double cost() {
		return .99;
	}

}
