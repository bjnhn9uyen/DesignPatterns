package ch04_FactoryMethodPattern.ConcreteProducts;

import ch04_FactoryMethodPattern.Pizza;

public class NYStyleCheesePizza extends Pizza {

	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}

}
