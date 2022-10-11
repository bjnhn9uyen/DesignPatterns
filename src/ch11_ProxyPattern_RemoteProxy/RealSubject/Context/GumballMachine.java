package ch11_ProxyPattern_RemoteProxy.RealSubject.Context;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch11_ProxyPattern_RemoteProxy.RealSubject.State;
import ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates.HasQuarterState;
import ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates.NoQuarterState;
import ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates.SoldOutState;
import ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates.SoldState;
import ch11_ProxyPattern_RemoteProxy.RealSubject.ConcreteStates.WinnerState;
import ch11_ProxyPattern_RemoteProxy.Subject.GumballMachineRemote;

// Extending the UnicastRemoteObject gives it the ability to act as a remote service,
// When you start the remote service, the UnicastRemoteObject’s constructor will be invoked,
// and the stub will be generated automatically.
// Implementing the GumballMachineRemote interface to handle requests coming from over the network.
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

	private static final long serialVersionUID = -7702610709444070946L;

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	State state = soldOutState;
	int count = 0;

	String location;

	public GumballMachine(String location, int numberGumballs) throws RemoteException {

		this.location = location;

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

	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = noQuarterState;
	}

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

	public String getLocation() {
		return location;
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

// Prior to Java 1.2, we generate the stubs and skeletons by using 'rmic' tool.
// These are the client and server ‘helpers’, but this technique is deprecated now.
// Skeletons are unnecessary, as of Java 1.2+, the RMI runtime can dispatch the client calls directly
// to the remote service using reflection. And in Java 5+, stubs are generated dynamically.
// So, now everything you need to get a client talking to a remote object is handled for you behind the scenes