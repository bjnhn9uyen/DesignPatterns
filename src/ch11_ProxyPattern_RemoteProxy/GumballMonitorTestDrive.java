package ch11_ProxyPattern_RemoteProxy;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ch11_ProxyPattern_RemoteProxy.Proxy.GumballMonitor;
import ch11_ProxyPattern_RemoteProxy.RealSubject.Context.GumballMachine;
import ch11_ProxyPattern_RemoteProxy.Subject.GumballMachineRemote;

public class GumballMonitorTestDrive {

	public static void main(String[] args) {

		// here’s all the machine locations we’re going to monitor
		String[] locations = { "santafe.mightygumball.com/gumballmachine",
										"boulder.mightygumball.com/gumballmachine",
										"austin.mightygumball.com/gumballmachine" };

		// create monitors for client-side, one for each machine location
		GumballMonitor[] monitors = new GumballMonitor[locations.length];

		for (int i = 0; i < locations.length; i++) {
			try {
				// To turn the GumballMachine to a remote service, and make it available to remote clients,
				// you do this by instantiating it and then bind it to the RMI registry.
				GumballMachineRemote gumballMachineRemote = new GumballMachine(locations[i], 2);

				// The RMI registry is a locator service, this is where the client goes to get the proxy/stub
				// An RMI Registry can be created manually using a terminal and start the rmiregistry.exe,
				// or created programmatically using the LocateRegistry class's static createRegistry method.
				// we want to make sure gum-ball machines on these locations are running
				int port = 5000 + i; // each GumballMachineRemote run on a different port (5000/5001/5002)
				LocateRegistry.createRegistry(port);
				Naming.rebind("rmi://localhost:" + port + "/" + locations[i], gumballMachineRemote);

				/** client-side */
				// the static lookup method takes a location with service name
				// and looks it up in the RMI registry at that location
				GumballMachineRemote machine = (GumballMachineRemote) Naming
										.lookup("rmi://localhost:" + port + "/" + locations[i]);
				// now each GumballMonitor has one remote machine for monitoring the real machine
				monitors[i] = new GumballMonitor(machine);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/** client-side */
		// iterate through each machine and print out its report
		for (int i = 0; i < monitors.length; i++) {
			monitors[i].report();
		}

	}

}
