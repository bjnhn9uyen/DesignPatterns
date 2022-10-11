package ch01_StrategyPattern;

import ch01_StrategyPattern.EncapsulatedFly.FlyBehavior;
import ch01_StrategyPattern.EncapsulatedQuack.QuackBehavior;

public abstract class Duck {

	// Duck subclasses inherit these instance variables to assign the concrete implementations at runtime
	// this is HAS-A relationships: each duck has a FlyBehavior and a QuackBehavior
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	// the Duck object delegates that behavior to the object referenced
	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	// include behavior setter methods so that we can change the Duck’s behavior at runtime
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

	abstract void display();

}
