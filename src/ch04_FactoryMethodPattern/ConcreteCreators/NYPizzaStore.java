package ch04_FactoryMethodPattern.ConcreteCreators;

import ch04_FactoryMethodPattern.Pizza;
import ch04_FactoryMethodPattern.PizzaStore;
import ch04_FactoryMethodPattern.ConcreteProducts.NYStyleCheesePizza;
import ch04_FactoryMethodPattern.ConcreteProducts.NYStyleClamPizza;
import ch04_FactoryMethodPattern.ConcreteProducts.NYStylePepperoniPizza;
import ch04_FactoryMethodPattern.ConcreteProducts.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (type.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (type.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (type.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else
			return null;
	}

}
