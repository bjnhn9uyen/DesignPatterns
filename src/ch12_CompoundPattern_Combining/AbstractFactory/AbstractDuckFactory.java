package ch12_CompoundPattern_Combining.AbstractFactory;

import ch12_CompoundPattern_Combining.Quackable;

public abstract class AbstractDuckFactory {

	public abstract Quackable createMallardDuck();

	public abstract Quackable createRedheadDuck();

	public abstract Quackable createDuckCall();

	public abstract Quackable createRubberDuck();

	public abstract Quackable createGooseDuck();

}
