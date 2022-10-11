package ch12_CompoundPattern_Combining.Observer;

import java.util.ArrayList;
import java.util.Iterator;

public class HelperObservable implements QuackObservable {

	ArrayList<QuackObserver> observers = new ArrayList<>();
	QuackObservable duck;

	// We compose this helper class with a QuackObservable object.
	// When a notify occurs (in the notify method below), Observable passes this object along
	// so that the observer knows which object is quacking
	public HelperObservable(QuackObservable duck) {
		this.duck = duck;
	}

	// the code for registering an observer
	@Override
	public void registerObserver(QuackObserver observer) {
		observers.add(observer);
	}

	// the code for doing the notifications
	@Override
	public void notifyObservers() {
		Iterator<QuackObserver> iterator = observers.iterator();
		while (iterator.hasNext()) {
			QuackObserver observer = (QuackObserver) iterator.next();
			observer.update(duck);
		}
	}
}

// We need to make sure all the concrete classes that implement Quackable can handle being a QuackObservable.
// We could approach this by implementing registration and notification in each and every class.
// But we’re going to do it a little differently this time, we’re going to encapsulate the registration
// and notification code in this helper class, and compose it with a QuackObservable.
// That way we only write the real code once and the QuackObservable just needs enough code to delegate
// to the helper class Observable. HelperObservable must implement QuackObservable
// because these are the same method calls that are going to be delegated to it.
// And then, we need to make sure the Quackable classes are composed with an Observable
// and that they know how to delegate to it. After that, they’re ready to be Observables.
