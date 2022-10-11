package ch03_DecoratorPattern.Component.ConcreteComponents;

import ch03_DecoratorPattern.Component.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		// the description instance variable is inherited from Beverage
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return .89;
	}

}
