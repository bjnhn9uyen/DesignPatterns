package ch06_CommandPattern.Commands;

import ch06_CommandPattern.VendorClasses.Light;

public class LightOffCommand implements Command {

	// receiver of the request
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	// the LightOffCommand works exactly the same way as the LightOnCommand,
	// except that we are binding the receiver to a different action: the off() method
	@Override
	public void execute() {
		light.off();
	}

}
