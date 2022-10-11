package ch03_DecoratorPattern.Component;

public abstract class Beverage {

	public String description = "Unknown Beverage"; // set ‘public’ for inheritance

	public String getDescription() {
		return description;
	}

	public abstract double cost();

}

// we could use interface instead of abstract class, but interfaces can not have instance variables
