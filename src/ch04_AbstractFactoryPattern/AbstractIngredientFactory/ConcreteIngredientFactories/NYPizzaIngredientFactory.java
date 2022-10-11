package ch04_AbstractFactoryPattern.AbstractIngredientFactory.ConcreteIngredientFactories;

import ch04_AbstractFactoryPattern.AbstractIngredientFactory.PizzaIngredientFactory;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Cheese;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Clams;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Dough;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Pepperoni;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Sauce;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Veggies;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteCheese.ReggianoCheese;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteClams.FreshClams;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteDough.ThinCrustDough;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcretePepperoni.SlicedPepperoni;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteSauce.MarinaraSauce;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.Garlic;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.Mushroom;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.Onion;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.RedPepper;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
