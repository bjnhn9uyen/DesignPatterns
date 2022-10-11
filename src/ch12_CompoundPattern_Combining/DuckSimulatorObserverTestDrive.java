package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.AbstractFactory.AbstractDuckFactory;
import ch12_CompoundPattern_Combining.AbstractFactory.CountingDuckFactory;
import ch12_CompoundPattern_Combining.Composite.Flock;
import ch12_CompoundPattern_Combining.Decorator.QuackCounter;
import ch12_CompoundPattern_Combining.Observer.Quackologist;

// six patterns (including the built-in Iterator Pattern) have come together to create this Duck Simulator
public class DuckSimulatorObserverTestDrive {

	public static void main(String[] args) {
		DuckSimulatorObserverTestDrive simulator = new DuckSimulatorObserverTestDrive();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulate(duckFactory);
	}

	void simulate(AbstractDuckFactory duckFactory) {

		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = duckFactory.createGooseDuck();

		Flock flockOfDucks = new Flock();
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);

		Flock flockOfMallards = new Flock();
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards);

		System.out.println("Duck Simulator With Observer");
		// all we do here is create a Quackologist and set him as an observer of the flock
		Quackologist quackologist = new Quackologist();
		flockOfDucks.registerObserver(quackologist);
		simulate(flockOfDucks); // we’ll just simulate the entire flock instead one by one
		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");

	}

	void simulate(Quackable duck) {
		duck.quack();
	}

}
