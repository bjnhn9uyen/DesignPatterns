package ch04_FactoryMethodPattern.ConcreteCreators;

import ch04_FactoryMethodPattern.Pizza;
import ch04_FactoryMethodPattern.PizzaStore;
import ch04_FactoryMethodPattern.ConcreteProducts.ChicagoStyleCheesePizza;
import ch04_FactoryMethodPattern.ConcreteProducts.ChicagoStyleClamPizza;
import ch04_FactoryMethodPattern.ConcreteProducts.ChicagoStylePepperoniPizza;
import ch04_FactoryMethodPattern.ConcreteProducts.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else
			return null;
	}

}
