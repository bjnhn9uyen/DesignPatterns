package ch10_StatePattern.ConcreteStates;

import java.util.Random;

import ch10_StatePattern.State;
import ch10_StatePattern.Context.GumballMachine;

public class HasQuarterState implements State {

	// We need to implement the random chance game (10%) and add a transition to the WinnerState.
	// First we add a random number generator to generate the 10% chance of winning,
	// then we determine if this customer won in the turnCrank() method
	Random randomWinner = new Random(System.currentTimeMillis());

	GumballMachine gumballMachine;

	// when the state is instantiated we pass it a reference to the GumballMachine,
	// this is used to transition the machine to a different state
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can’t insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		// if they won, and there’s enough gum-balls left for them to get two, we go to the WinnerState,
		// otherwise, we go to the SoldState (just like we always did)
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

}
