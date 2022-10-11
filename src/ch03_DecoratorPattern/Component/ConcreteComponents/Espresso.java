package ch03_DecoratorPattern.Component.ConcreteComponents;

import ch03_DecoratorPattern.Component.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		// the description instance variable is inherited from Beverage
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
