package ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates;

import ch11_ProxyPattern_RemoteProxy.RealSubject.State;
import ch11_ProxyPattern_RemoteProxy.RealSubject.Context.GumballMachine;

public class NoQuarterState implements State {

	private static final long serialVersionUID = 902843302330111119L;

	// the 'transient' keyword tells the JVM not to serialize this field
	transient GumballMachine gumballMachine;

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
