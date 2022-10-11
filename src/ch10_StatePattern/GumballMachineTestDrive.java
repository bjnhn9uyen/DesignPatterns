package ch10_StatePattern;

import ch10_StatePattern.Context.GumballMachine;

public class GumballMachineTestDrive {

	public static void main(String[] args) {

		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		// we want to get a winning state, so we just keep pumping in those quarters and turning the crank
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

	}

}
