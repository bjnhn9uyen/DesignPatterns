package ch10_StatePattern.ConcreteStates;

import ch10_StatePattern.State;
import ch10_StatePattern.Context.GumballMachine;

public class NoQuarterState implements State {

	GumballMachine gumballMachine;

	// when the state is instantiated we pass it a reference to the GumballMachine,
	// this is used to transition the machine to a different state
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven’t inserted a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there’s no quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}

	@Override
	public String toString() {
		return "waiting for quarter";
	}

}
