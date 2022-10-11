package ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates;

import ch11_ProxyPattern_RemoteProxy.RealSubject.State;
import ch11_ProxyPattern_RemoteProxy.RealSubject.Context.GumballMachine;

public class SoldState implements State {

	private static final long serialVersionUID = 7489460220150382978L;

	// the 'transient' keyword tells the JVM not to serialize this field
	transient GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
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

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
