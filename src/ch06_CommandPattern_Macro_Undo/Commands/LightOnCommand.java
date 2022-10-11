package ch06_CommandPattern_Macro_Undo.Commands;

import ch06_CommandPattern_Macro_Undo.VendorClasses.Light;

public class LightOnCommand implements Command {

	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	// If the LightOnCommand’s execute() method was called, then the on() method was last called
	// We know that undo() needs to do the opposite of this by calling the off() method
	@Override
	public void undo() {
		light.off();
	}

}
