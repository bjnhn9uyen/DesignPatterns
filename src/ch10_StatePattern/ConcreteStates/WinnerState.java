package ch10_StatePattern.ConcreteStates;

import ch10_StatePattern.State;
import ch10_StatePattern.Context.GumballMachine;

public class WinnerState implements State {

	GumballMachine gumballMachine;

	// when the state is instantiated we pass it a reference to the GumballMachine,
	// this is used to transition the machine to a different state
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we’re already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn’t get you another gumball!");
	}

	// Here we release two gum-balls and then either go to the NoQuarterState or the SoldOutState.
	@Override
	public void dispense() {
		System.out.println("YOU’RE A WINNER! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

}
