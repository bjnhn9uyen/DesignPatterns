package ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteCheese;

import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Cheese;

public class MozzarellaCheese implements Cheese {

	@Override
	public String toString() {
		return "Shredded Mozzarella";
	}

}
