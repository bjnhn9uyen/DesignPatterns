package ch04_SimpleFactory;

import ch04_SimpleFactory.ConcreteProducts.CheesePizza;
import ch04_SimpleFactory.ConcreteProducts.ClamPizza;
import ch04_SimpleFactory.ConcreteProducts.PepperoniPizza;
import ch04_SimpleFactory.ConcreteProducts.VeggiePizza;

public class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		return pizza;
	}

}
