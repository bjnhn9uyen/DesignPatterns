package ch11_ProxyPattern_RemoteProxy.Subject;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ch11_ProxyPattern_RemoteProxy.RealSubject.State;

// Both the Proxy and the RealSubject implement the Subject interface.
// This allows any client to treat the proxy just like the RealSubject.
public interface GumballMachineRemote extends Remote {

	// Here are the methods were going to support.
	// All return types of the methods need to be primitive or Serializable.
	// In the State interface, we just extend the Serializable interface,
	// and State in all the subclasses can be transferred over the network.
	public int getCount() throws RemoteException;

	public String getLocation() throws RemoteException;

	public State getState() throws RemoteException;

}
