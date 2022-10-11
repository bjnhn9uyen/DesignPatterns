package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.Observer.HelperObservable;
import ch12_CompoundPattern_Combining.Observer.QuackObserver;

// duck calls are those things hunters use, they are definitely quackable
public class DuckCall implements Quackable {

	// each Quackable has an Observable instance variable
	HelperObservable observable;

	// create an Observable and pass it a reference to the Quackable object (DuckCall object)
	public DuckCall() {
		observable = new HelperObservable(this);
	}

	@Override
	public void quack() {
		System.out.println("Kwak");
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
		return "Duck-call";
	}

}
