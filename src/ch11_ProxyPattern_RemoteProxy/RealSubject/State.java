package ch11_ProxyPattern_RemoteProxy.RealSubject;

import java.io.Serializable;

// Extend the Serializable interface to make State in all the subclasses can be transferred over the network.
// Each State object of the subclasses maintains a reference to a gum-ball machine,
// so that it can call the gum-ball machine’s methods and change its state. We just want to call the methods,
// we don’t want the entire gum-ball machine serialized and transferred with the State object.
// So, in each implementation of State, we add the 'transient' keyword to the GumballMachine instance variable
// to tell the JVM not to serialize the GumballMachine instance.
public interface State extends Serializable {

	public void insertQuarter();

	public void ejectQuarter();

	public void turnCrank();

	public void dispense();

}
