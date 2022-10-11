package ch12_CompoundPattern_Combining.Decorator;

import ch12_CompoundPattern_Combining.Quackable;
import ch12_CompoundPattern_Combining.Adapter.GooseAdapter;
import ch12_CompoundPattern_Combining.Observer.QuackObserver;

public class QuackCounter implements Quackable {

	Quackable duck; // here’s the duck that the QuackCounter is decorating
	static int numberOfQuacks; // we’re counting all quacks, so we’ll use a static variable to keep track

	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	// when quack() is called, we delegate the call to the Quackable we’re decorating
	@Override
	public void quack() {
		if (!(duck instanceof GooseAdapter)) {
			duck.quack();
			numberOfQuacks++;
		}
	}

	public static int getQuacks() {
		return numberOfQuacks;
	}

	// QuackCounter is a Quackable, so it’s a QuackObservable too.
	// So we have to implement these two methods of the QuackObservable interface.
	// Notice that we just delegate both calls to the duck that we’re decorating
	@Override
	public void registerObserver(QuackObserver observer) {
		duck.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		duck.notifyObservers();
	}

}
