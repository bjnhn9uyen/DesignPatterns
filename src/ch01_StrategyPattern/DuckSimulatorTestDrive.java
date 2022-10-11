package ch01_StrategyPattern;

import ch01_StrategyPattern.EncapsulatedFly.FlyFamily.FlyRocketPowered;

public class DuckSimulatorTestDrive {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck redhead = new RedheadDuck();
		Duck rubberDuckie = new RubberDuck();
		Duck decoy = new DecoyDuck();

		System.out.println("Mallard Duck:");
		mallard.performQuack();
		mallard.performFly();
		System.out.println("\nRedhead Duck:");
		redhead.performQuack();
		redhead.performFly();
		System.out.println("\nRubber Duck:");
		rubberDuckie.performQuack();
		rubberDuckie.performFly();

		System.out.println("\nDecoy Duck:");
		decoy.performFly(); // delegate to the flyBehavior in the DecoyDuck constructor
		// call the inherited behavior setter method to changed its flying behavior dynamically
		decoy.setFlyBehavior(new FlyRocketPowered());
		decoy.performFly();
	}

}
