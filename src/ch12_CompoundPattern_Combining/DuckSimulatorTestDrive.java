package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.AbstractFactory.AbstractDuckFactory;
import ch12_CompoundPattern_Combining.AbstractFactory.CountingDuckFactory;
import ch12_CompoundPattern_Combining.Decorator.QuackCounter;

public class DuckSimulatorTestDrive {

	public static void main(String[] args) {
		DuckSimulatorTestDrive simulator = new DuckSimulatorTestDrive();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulate(duckFactory);
	}

	void simulate(AbstractDuckFactory duckFactory) {
		// We create one of each Quackable, then we simulate each one.
		// We must wrap each Quackable object we instantiate in a QuackCounter decorator.
		// We don’t want to count geese honks, so we don’t decorate it.
		// If there's too many quacks, we have to make sure they get wrapped (every single one of them).
		// Let’s take the duck creation and decorating and encapsulate it. We need a factory to produce ducks.
		// The factory should produce a family of products that consists of different types of ducks,
		// so we’re going to use the Abstract Factory Pattern
//		Quackable mallardDuck = new QuackCounter(new MallardDuck());
//		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
//		Quackable duckCall = new QuackCounter(new DuckCall());
//		Quackable rubberDuck = new QuackCounter(new RubberDuck());
//		// we make a Goose that acts like a Duck by wrapping the Goose in the GooseAdapter
//		Quackable gooseDuck = new GooseAdapter(new Goose());

		// same as above, but we’re ensuring that the ducks are all decorated using the CountingDuckFactory
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = duckFactory.createGooseDuck();

		System.out.println("Duck Simulator");
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck); // once the Goose is wrapped, we can treat it just like other duck Quackables.

		// gather the quacking behavior
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}

	// here we overload the simulate method to simulate just one duck. Here we let polymorphism do its magic,
	// no matter what kind of Quackable gets passed in, the simulate() method asks it to quack
	void simulate(Quackable duck) {
		duck.quack();
	}

}
