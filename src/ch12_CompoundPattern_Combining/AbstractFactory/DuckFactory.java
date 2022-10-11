package ch12_CompoundPattern_Combining.AbstractFactory;

import ch12_CompoundPattern_Combining.DuckCall;
import ch12_CompoundPattern_Combining.Goose;
import ch12_CompoundPattern_Combining.MallardDuck;
import ch12_CompoundPattern_Combining.Quackable;
import ch12_CompoundPattern_Combining.RedheadDuck;
import ch12_CompoundPattern_Combining.RubberDuck;
import ch12_CompoundPattern_Combining.Adapter.GooseAdapter;

public class DuckFactory extends AbstractDuckFactory {

	// Each method creates a product, a particular kind of Quackable
	// The actual product is unknown to the simulator, it just knows it’s getting a Quackable

	@Override
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}

	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}

	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}

	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}

	@Override
	public Quackable createGooseDuck() {
		return new GooseAdapter(new Goose());
	}

}
