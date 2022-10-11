package ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteClams;

import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Clams;

public class FreshClams implements Clams {

	@Override
	public String toString() {
		return "Fresh Clams from Long Island Sound";
	}

}
