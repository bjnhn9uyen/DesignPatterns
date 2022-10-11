package ch10_StatePattern;

// We define a State interface that contains a method for every action in the Gum-ball Machine.
// Then we’re going to implement a State class for every state of the machine.
// These classes will be responsible for the behavior of the machine when it is in the corresponding state.
// And then we’re going to get rid of all of our conditional code and instead delegate to the state class
public interface State {

	public void insertQuarter();

	public void ejectQuarter();

	public void turnCrank();

	public void dispense();

}
