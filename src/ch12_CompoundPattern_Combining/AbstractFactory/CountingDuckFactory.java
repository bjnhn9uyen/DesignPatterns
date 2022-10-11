package ch12_CompoundPattern_Combining.AbstractFactory;

import ch12_CompoundPattern_Combining.DuckCall;
import ch12_CompoundPattern_Combining.Goose;
import ch12_CompoundPattern_Combining.MallardDuck;
import ch12_CompoundPattern_Combining.Quackable;
import ch12_CompoundPattern_Combining.RedheadDuck;
import ch12_CompoundPattern_Combining.RubberDuck;
import ch12_CompoundPattern_Combining.Adapter.GooseAdapter;
import ch12_CompoundPattern_Combining.Decorator.QuackCounter;

public class CountingDuckFactory extends AbstractDuckFactory {

	// Each method wraps the Quackable with the quack counting decorator.
	// The simulator will never know the difference; it just gets back a Quackable.

	@Override
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}

	@Override
	public Quackable createGooseDuck() {
		return new QuackCounter(new GooseAdapter(new Goose()));
	}

}
