package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.Observer.HelperObservable;
import ch12_CompoundPattern_Combining.Observer.QuackObserver;

public class RedheadDuck implements Quackable {

	// each Quackable has an Observable instance variable
	HelperObservable observable;

	// create an Observable and pass it a reference to the Quackable object (RedheadDuck object)
	public RedheadDuck() {
		observable = new HelperObservable(this);
	}

	@Override
	public void quack() {
		System.out.println("Quack");
		// when we quack, we need to let the observers know about it
		notifyObservers();
	}

	// here’s our two QuackObservable methods, we just delegate to the helper observable
	@Override
	public void registerObserver(QuackObserver observer) {
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}

	@Override
	public String toString() {
		return "Redhead Duck";
	}

}
