package ch12_CompoundPattern_Combining.Observer;

// QuackObservable is the interface that Quackables class should implement if they want to be observed
public interface QuackObservable {

	// An Observable needs methods for registering and notifying observers.
	// We could also have a method for removing observers, but we’ll keep the implementation simple here

	public void registerObserver(QuackObserver observer);

	public void notifyObservers();

}
