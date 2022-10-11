package ch03_DecoratorPattern.Decorator.ConcereteDecorators;

import ch03_DecoratorPattern.Component.Beverage;
import ch03_DecoratorPattern.Decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	// this class inherits the Beverage instance variable to hold the beverage we are wrapping,
	// we’re passing the beverage we’re wrapping to the decorator’s constructor
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
