package ch10_StatePattern.WithoutPattern;

public class GumballMachine {

	// we have four states in total: No Quarter; Has Quarter; Sold Out (Out of Gum-balls); Gum-ball Sold
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;

	int state = SOLD_OUT; // keep track of the current state we’re in, start in the SOLD_OUT state
	int count = 0; // keeps track of the number of gum-balls in the machine

	// The constructor takes an initial inventory of gum-balls. If the inventory isn’t zero,
	// the machine enters state NO_QUARTER, meaning it is waiting for someone to insert a quarter
	public GumballMachine(int numberGumballs) {
		this.count = numberGumballs;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}

	// For actions, we need to implement inserting a quarter, removing a quarter, turning the crank,
	// dispensing a gum-ball, we also have the empty gum-ball condition to implement as well.
	// For each action, we create a method that uses conditional statements to determine
	// what behavior is appropriate in each state
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("You can’t insert another quarter");
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You can’t insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			System.out.println("Please wait, we’re already giving you a gumball");
		}
	}

	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			System.out.println("You haven’t inserted a quarter");
		} else if (state == SOLD) {
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
			System.out.println("You can’t eject, you haven’t inserted a quarter yet");
		}
	}

	public void turnCrank() {
		if (state == SOLD) {
			System.out.println("Turning twice doesn’t get you another gumball!");
		} else if (state == NO_QUARTER) {
			System.out.println("You turned but there’s no quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}

	public void dispense() {
		if (state == SOLD) {
			System.out.println("A gumball comes rolling out the slot");
			count = count - 1;
			if (count == 0) {
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}

	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}

}

// Change request: 10% of the time, when the crank is turned, the customer gets two gum-balls instead of one.
// There’s a lot of code to modify. First, you’d have to add a new ‘winner’ state.
// But then, you’d have to add a new conditional in every single method to handle the ‘winner’ state.
// Instead of maintaining our existing code, we’re going to rework it to encapsulate state objects
// in their own classes and then delegate to the current state when an action occurs
