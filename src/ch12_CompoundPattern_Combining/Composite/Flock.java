package ch12_CompoundPattern_Combining.Composite;

import java.util.ArrayList;
import java.util.Iterator;

import ch12_CompoundPattern_Combining.Quackable;
import ch12_CompoundPattern_Combining.Observer.QuackObserver;

// What we need is a way to manage a flock (collections) of ducks and even sub-collections of ducks.
// It would also be nice if we could apply operations across the whole set of ducks.
// Composite Pattern allows us to treat a collection of objects in the same way as individual objects
// The composite needs to implement the same interface as the leaf elements, our leaf elements are Quackables
public class Flock implements Quackable {

	ArrayList<Quackable> quackers = new ArrayList<>();

	// method to add a Quackable to the Flock
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}

	@Override
	public void quack() {
		// the Iterator Pattern at work!
		Iterator<Quackable> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = (Quackable) iterator.next();
			quacker.quack();
		}
	}

	@Override
	public void registerObserver(QuackObserver observer) {
		// iterate through all the Quackables in the Flock and delegate the call to each Quackable
		Iterator<Quackable> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable duck = (Quackable) iterator.next();
			duck.registerObserver(observer);
		}
	}

	@Override
	public void notifyObservers() {
		// each Quackable does its own notification, so Flock doesn’t have to worry about it.
	}

}
