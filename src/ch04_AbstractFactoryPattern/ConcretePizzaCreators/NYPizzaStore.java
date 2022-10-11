package ch04_AbstractFactoryPattern.ConcretePizzaCreators;

import ch04_AbstractFactoryPattern.Pizza;
import ch04_AbstractFactoryPattern.PizzaStore;
import ch04_AbstractFactoryPattern.AbstractIngredientFactory.PizzaIngredientFactory;
import ch04_AbstractFactoryPattern.AbstractIngredientFactory.ConcreteIngredientFactories.NYPizzaIngredientFactory;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.CheesePizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.ClamPizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.PepperoniPizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.VeggiePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		if (type.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		} else if (type.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		}
		return pizza;
	}

}
