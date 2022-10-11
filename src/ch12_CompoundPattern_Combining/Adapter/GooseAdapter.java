package ch12_CompoundPattern_Combining.Adapter;

import ch12_CompoundPattern_Combining.Goose;
import ch12_CompoundPattern_Combining.Quackable;
import ch12_CompoundPattern_Combining.Observer.HelperObservable;
import ch12_CompoundPattern_Combining.Observer.QuackObserver;

public class GooseAdapter implements Quackable {

	Goose goose;

	// each Quackable has an Observable instance variable
	HelperObservable observable;

	// The constructor takes the goose we are going to adapt.
	// When quack is called, the call is delegated to the goose’s honk() method
	public GooseAdapter(Goose goose) {
		this.goose = goose;
		// create an Observable and pass it a reference to the Quackable object (GooseAdapter object)
		observable = new HelperObservable(this);
	}

	@Override
	public void quack() {
		goose.honk();
		// when we quack (honk actually), we need to let the observers know about it
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

}
