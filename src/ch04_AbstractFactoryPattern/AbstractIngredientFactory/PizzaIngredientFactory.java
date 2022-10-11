package ch04_AbstractFactoryPattern.AbstractIngredientFactory;

import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Cheese;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Clams;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Dough;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Pepperoni;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Sauce;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Veggies;

public interface PizzaIngredientFactory {

	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Veggies[] createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClam();

}
