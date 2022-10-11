package ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates;

import ch11_ProxyPattern_RemoteProxy.RealSubject.State;
import ch11_ProxyPattern_RemoteProxy.RealSubject.Context.GumballMachine;

public class SoldOutState implements State {

	private static final long serialVersionUID = 3539146715337496711L;
	
	// the 'transient' keyword tells the JVM not to serialize this field
	transient GumballMachine gumballMachine;

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
