package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.AbstractFactory.AbstractDuckFactory;
import ch12_CompoundPattern_Combining.AbstractFactory.CountingDuckFactory;
import ch12_CompoundPattern_Combining.Composite.Flock;
import ch12_CompoundPattern_Combining.Decorator.QuackCounter;

public class DuckSimulatorCompositeTestDrive {

	public static void main(String[] args) {
		DuckSimulatorCompositeTestDrive simulator = new DuckSimulatorCompositeTestDrive();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulate(duckFactory);
	}

	void simulate(AbstractDuckFactory duckFactory) {

		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = duckFactory.createGooseDuck();

		// create a Flock, and load it up with Quackables
		Flock flockOfDucks = new Flock();
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);

		// create a new Flock of Mallards, and then create a little family of Mallards,
		// and adding them to the Flock of Mallards
		Flock flockOfMallards = new Flock();
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards); // add the Flock of Mallards to the main flock

		System.out.println("Duck Simulator: Whole Flock Simulation");
		simulate(flockOfDucks); // we’ll just simulate the entire flock instead one by one
		System.out.println("\nDuck Simulator: Mallard Flock Simulation");
		simulate(flockOfMallards);

		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
	}

	void simulate(Quackable duck) {
		duck.quack();
	}

}
