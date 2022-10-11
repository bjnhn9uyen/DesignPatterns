package ch03_DecoratorPattern;

import ch03_DecoratorPattern.Component.Beverage;
import ch03_DecoratorPattern.Component.ConcreteComponents.DarkRoast;
import ch03_DecoratorPattern.Component.ConcreteComponents.Espresso;
import ch03_DecoratorPattern.Component.ConcreteComponents.HouseBlend;
import ch03_DecoratorPattern.Decorator.ConcereteDecorators.Mocha;
import ch03_DecoratorPattern.Decorator.ConcereteDecorators.Soy;
import ch03_DecoratorPattern.Decorator.ConcereteDecorators.Whip;

public class StarbuzzCoffee {

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

	}

}
