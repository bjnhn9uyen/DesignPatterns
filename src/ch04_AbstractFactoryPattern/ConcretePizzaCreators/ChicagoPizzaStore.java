package ch04_AbstractFactoryPattern.ConcretePizzaCreators;

import ch04_AbstractFactoryPattern.Pizza;
import ch04_AbstractFactoryPattern.PizzaStore;
import ch04_AbstractFactoryPattern.AbstractIngredientFactory.PizzaIngredientFactory;
import ch04_AbstractFactoryPattern.AbstractIngredientFactory.ConcreteIngredientFactories.ChicagoPizzaIngredientFactory;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.CheesePizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.ClamPizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.PepperoniPizza;
import ch04_AbstractFactoryPattern.ConcretePizzaProducts.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
		if (type.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");
		} else if (type.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");
		}
		return pizza;
	}

}
