package ch11_ProxyPattern_RemoteProxy.Proxy;

import java.rmi.RemoteException;

import ch11_ProxyPattern_RemoteProxy.Subject.GumballMachineRemote;

// The Proxy acts as a local representative for a real object (GumballMachine) that lives in a different JVM.
// The Proxy keeps a reference to the Subject (GumballMachineRemote) so it can forward requests to the Subject
// and retrieve the machine’s location, inventory of gum-balls and the current machine state
// and prints them in a nice little report for the Client
public class GumballMonitor {

	// we rely on the remote interface rather than the concrete GumballMachine class
	GumballMachineRemote machineRemote;

	public GumballMonitor(GumballMachineRemote machineRemote) {
		this.machineRemote = machineRemote;
	}

	public void report() {
		try {
			System.out.println("\nGumball Machine: " + machineRemote.getLocation());
			System.out.println("Current inventory: " + machineRemote.getCount() + " gumballs");
			System.out.println("Current state: " + machineRemote.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
