package ch12_CompoundPattern_Combining.Observer;

// we need to implement the QuackObserver interface to register with a QuackObservable
public class Quackologist implements QuackObserver {

	@Override
	public void update(QuackObservable duck) {
		System.out.println("Quackologist: " + duck + " just quacked.");
	}

}
