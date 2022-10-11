package ch10_StatePattern.Context;

import ch10_StatePattern.State;
import ch10_StatePattern.ConcreteStates.HasQuarterState;
import ch10_StatePattern.ConcreteStates.NoQuarterState;
import ch10_StatePattern.ConcreteStates.SoldOutState;
import ch10_StatePattern.ConcreteStates.SoldState;
import ch10_StatePattern.ConcreteStates.WinnerState;

public class GumballMachine {

	// switch the code from using integers to using state objects
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	State state = soldOutState;
	int count = 0;

	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);

		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	// For the actions, we just delegate to the current state
	// We don’t need an action method for dispense() in GumballMachine because it’s just an internal action.
	// Users can’t ask the machine to dispense directly. We do call dispense() from the turnCrank() method
	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	// the machine supports a releaseBall() method to release the ball and decrements the count variable
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	// refill the gum-ball machine when it’s out of gum-balls!
	void refill(int numGumBalls) {
		this.count = numGumBalls; // update the gum-ball machine
		state = noQuarterState; // reset the machine’s state
	}

	// These methods allow other objects (State objects) to transition the machine to a different state
	public void setState(State state) {
		this.state = state;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

}
