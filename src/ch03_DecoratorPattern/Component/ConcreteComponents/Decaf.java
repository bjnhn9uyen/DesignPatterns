package ch03_DecoratorPattern.Component.ConcreteComponents;

import ch03_DecoratorPattern.Component.Beverage;

public class Decaf extends Beverage {

	public Decaf() {
		// the description instance variable is inherited from Beverage
		description = "Decaf";
	}

	@Override
	public double cost() {
		return 1.05;
	}

}
