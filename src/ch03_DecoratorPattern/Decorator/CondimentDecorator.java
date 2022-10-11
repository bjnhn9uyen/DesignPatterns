package ch03_DecoratorPattern.Decorator;

import ch03_DecoratorPattern.Component.Beverage;

public abstract class CondimentDecorator extends Beverage {

	// we need to be interchangeable with a Beverage, so we extend the Beverage class
	// we are using the Beverage super type to refer to the Beverage so each Decorator can wrap any beverage
	public Beverage beverage; // set ‘public’ for inheritance

	@Override
	public abstract String getDescription();

	@Override
	public double cost() {
		return 0;
	}

}
