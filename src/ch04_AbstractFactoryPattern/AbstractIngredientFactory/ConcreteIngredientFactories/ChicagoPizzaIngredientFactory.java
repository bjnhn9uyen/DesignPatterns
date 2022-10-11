package ch04_AbstractFactoryPattern.AbstractIngredientFactory.ConcreteIngredientFactories;

import ch04_AbstractFactoryPattern.AbstractIngredientFactory.PizzaIngredientFactory;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Cheese;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Clams;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Dough;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Pepperoni;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Sauce;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.Veggies;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteCheese.MozzarellaCheese;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteClams.FrozenClams;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteDough.ThickCrustDough;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcretePepperoni.SlicedPepperoni;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteSauce.PlumTomatoSauce;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.BlackOlives;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.Eggplant;
import ch04_AbstractFactoryPattern.AbstractIngredientProducts.ConcreteVeggies.Spinach;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), new Spinach(), new Eggplant() };
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
