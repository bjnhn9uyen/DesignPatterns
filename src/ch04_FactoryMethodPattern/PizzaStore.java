package ch04_FactoryMethodPattern;

public abstract class PizzaStore {

	public final Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	// Factory method - implemented in all creators
	protected abstract Pizza createPizza(String type);

}
