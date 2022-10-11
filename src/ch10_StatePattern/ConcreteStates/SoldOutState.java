package ch10_StatePattern.ConcreteStates;

import ch10_StatePattern.State;
import ch10_StatePattern.Context.GumballMachine;

public class SoldOutState implements State {

	GumballMachine gumballMachine;

	// when the state is instantiated we pass it a reference to the GumballMachine,
	// this is used to transition the machine to a different state
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can’t insert a quarter, the machine is sold out");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

}
