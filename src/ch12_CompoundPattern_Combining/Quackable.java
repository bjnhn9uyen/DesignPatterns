package ch12_CompoundPattern_Combining;

import ch12_CompoundPattern_Combining.Observer.QuackObservable;

public interface Quackable extends QuackObservable {

	public void quack();

}
